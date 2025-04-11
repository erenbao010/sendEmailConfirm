package com.sendEmailSpringBoot.demo.controller;

import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping(path = "/userInfo")
public class DashBoardController {
    private UserService userServiceDashBoard;

    public DashBoardController(UserService userServiceDashBoard) {
        this.userServiceDashBoard = userServiceDashBoard;
    }
    @GetMapping
    public ResponseEntity<?> getUserName(@AuthenticationPrincipal OAuth2User principal) {
        String fullName =  principal.getAttribute("name");
        System.out.println("Google Attributes: " + principal.getAttributes());
        return ResponseEntity.ok(Collections.singletonMap("name", fullName));
    }
    }


