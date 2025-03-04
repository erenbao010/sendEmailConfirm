package com.example.CTGTDL.controller;

import com.example.CTGTDL.dto.request.UserCreationRequest;
import com.example.CTGTDL.entity.User;
import com.example.CTGTDL.repository.UserRepository;
import com.example.CTGTDL.service.UserService;
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
    User getUser (@PathVariable("userId") long userId) {
        return userService.getUser(userId);
    }
    @PostMapping
    User createUser (@RequestBody UserCreationRequest creationRequest) {
        return  userService.createUser(creationRequest);
    }

}
