package cn.bnm.league_of_legends_universe_backend.controller;

import cn.bnm.league_of_legends_universe_backend.entity.User;
import cn.bnm.league_of_legends_universe_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/user")
public class UserController {@Autowired
private UserMapper userMapper;

    /**
     * 用户登录接口
     */
    @PostMapping("/login")
    @ResponseBody
    public int login(HttpServletRequest request, @RequestBody User user) {
        User userInDb = userMapper.findByUsername(user.getUsername());
        if (userInDb != null && userInDb.getPassword().equals(user.getPassword())) {
            request.getSession().setAttribute("user", userInDb);
            return 1; // 登录成功
        } else if (userInDb != null) {
            return 0; // 密码错误
        } else {
            return -1; // 账户不存在
        }
    }

    /**
     * 用户注册接口
     */
    @PostMapping("/register")
    @ResponseBody
    public Map<String, Object> register(HttpServletRequest request, @RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        User userInDb = userMapper.findByUsername(user.getUsername());
        if (userInDb != null) {
            result.put("code", 400);
            result.put("msg", "该用户名已被注册！");
        } else {
            userMapper.insert(user);
            result.put("code", 200);
            result.put("msg", "注册成功！");
            request.getSession().setAttribute("user", user);
        }
        return result;
    }
}