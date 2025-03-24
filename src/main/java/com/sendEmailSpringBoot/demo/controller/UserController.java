package com.sendEmailSpringBoot.demo.controller;


import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.request.UserCreationRequest;
import com.sendEmailSpringBoot.demo.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

    @GetMapping("/{Id}")
    User getUser(@PathVariable("userId") long Id) {
        return userService.getUser(Id);
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
    User createUser(@RequestBody @Valid UserCreationRequest creationRequest) {
        return userService.createUser(creationRequest);
    }

    @GetMapping("/name/{name}")
    public User findByName (@PathVariable String name) {
        return userService.findByname(name);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> editUser(@PathVariable long id, @RequestBody User user) {
        User editUser = userService.updateUser(id, user);
        return ResponseEntity.ok(editUser);

    }

}
