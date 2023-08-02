package cn.bnm.league_of_legends_universe_backend.controller;

import cn.bnm.league_of_legends_universe_backend.entity.Role;
import cn.bnm.league_of_legends_universe_backend.mapper.RoleMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class RoleInfoController {

    @Autowired
    private RoleMapper roleMapper;

    @GetMapping("/roles")
    public String getRoles() {
        try {
            List<Role> roles = roleMapper.findAllRoles();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(roles);
            return json;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}