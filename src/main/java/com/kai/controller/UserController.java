package com.kai.controller;

import com.kai.entity.User;
import com.kai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Wangkai
 * @description
 * @date 2021/12/18
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{userId}")
    public User getUser(@PathVariable String userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/get")
    public User getUserById(@RequestBody User user) {
        return userService.getUser(user.getUserId());
    }

    @GetMapping
    public List<User> listUser() {
        return userService.listUser();
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
