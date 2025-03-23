package com.sendEmailSpringBoot.demo.controller;


import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.request.UserCreationRequest;
import com.sendEmailSpringBoot.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

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

    @GetMapping
    List<User> getAllUser() {
        return userService.getAllUser();
    }

    @GetMapping("/size")
    Long getSizeUser() {
        return userService.getSize();
    }
    @PostMapping()
    User createUser(@RequestBody UserCreationRequest creationRequest) {
        return userService.createUser(creationRequest);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable long id, @RequestBody User user) {
        User editUser = userService.updateUser(id, user);
        return ResponseEntity.ok(editUser);

    }

}
