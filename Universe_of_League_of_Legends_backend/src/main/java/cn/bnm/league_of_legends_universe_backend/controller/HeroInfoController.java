package cn.bnm.league_of_legends_universe_backend.controller;

import cn.bnm.league_of_legends_universe_backend.entity.Hero;
import cn.bnm.league_of_legends_universe_backend.mapper.HeroMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class HeroInfoController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, Vue!";
    }

    @Autowired
    private HeroMapper heroMapper;

    @GetMapping("/heroes")
    public String getHeroes() {
        try {
            List<Hero> heroes = heroMapper.findAllHeroes();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(heroes);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    @GetMapping("/fuzzyQuery")
    public String fuzzyQuery(@RequestParam("keyword") String keyword) {
        try {
            List<Hero> heroes = heroMapper.FuzzyQueries(keyword);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(heroes);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    //根据formerly查询
    @GetMapping("/findHero")
    public String findHeroByFormerly(@RequestParam("formerly") String formerly) {
        try {
            Hero hero = heroMapper.findByFormerly(formerly);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(hero);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    //根据relevantRegion查询
    @GetMapping("/findHeroesByRegion")
    public String findHeroByRegion(@RequestParam("region") String region) {
        try {
            List<Hero> heroes = heroMapper.findHeroesByRegional(region);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(heroes);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

}