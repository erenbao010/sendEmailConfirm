package com.sendEmailSpringBoot.demo.controller;

import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.request.UserCreationRequest;
import com.sendEmailSpringBoot.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/id", consumes = "application/json")
    User createUserId(@RequestBody UserCreationRequest creationRequest) {
        return userService.createUser(creationRequest);
    }

    @GetMapping("/{userId}")
    User getUser(@PathVariable("userId") long userId) {
        return userService.getUser(userId);
    }

    @PostMapping
    User createUser(@RequestBody UserCreationRequest creationRequest) {
        return userService.createUser(creationRequest);
    }

}
