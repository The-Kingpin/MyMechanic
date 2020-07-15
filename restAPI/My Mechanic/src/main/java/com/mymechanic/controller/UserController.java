package com.mymechanic.controller;

import com.mymechanic.entities.User;
import com.mymechanic.service.UserService;
import com.mymechanic.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getUserByUsername(){
        System.out.println("getUserByUsername");
        return this.userService.findUserByUsername("user");
    }
}
