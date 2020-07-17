package com.mymechanic.restapi.controller;

import com.mymechanic.entities.User;
import com.mymechanic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable(name = "username") String username) {
        System.out.println("Find by username");
        try {
            return this.userService.findUserByUsername(username);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {

        try {
            this.userService.addUser(user);
        }catch (EntityExistsException e) {
            throw  new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
        }

        return user;
    }
}
