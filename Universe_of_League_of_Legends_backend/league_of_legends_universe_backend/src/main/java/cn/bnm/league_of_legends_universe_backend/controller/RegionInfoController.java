package cn.bnm.league_of_legends_universe_backend.controller;

import cn.bnm.league_of_legends_universe_backend.entity.Region;
import cn.bnm.league_of_legends_universe_backend.mapper.HeroMapper;
import cn.bnm.league_of_legends_universe_backend.mapper.RegionMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RegionInfoController {
    @Autowired
    private RegionMapper regionMapper;

    @GetMapping("/region")
    public String getRegional() {
        try {
            List<Region> regions = regionMapper.findAllRegions();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(regions);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
    //根据formerly查询regional
    @GetMapping("/findRegion")
    public String findRegion(@RequestParam("formerly") String formerly) {
        try {
            Region region = regionMapper.findRegionByFormerly(formerly);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(region);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
