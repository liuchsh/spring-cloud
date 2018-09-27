package com.cs.ln.user.controller;

import com.cs.ln.user.UserService;
import com.cs.ln.user.model.User;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * {@link User 用户}控制器
 *
 * @Author liuchsh
 * @date 2018/9/22
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public User save(@RequestBody User user) {
        if(userService.save(user)) {
            System.out.println("保存用户: " + user);
            return user;
        }else {
            return null;
        }
    }

    @GetMapping("/list")
    public Collection<User> list() {
        System.out.println("获取所有用户列表");
        return userService.findAll();
    }
}
