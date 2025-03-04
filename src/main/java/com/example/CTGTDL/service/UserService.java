package com.example.CTGTDL.service;

import com.example.CTGTDL.dto.request.UserCreationRequest;
import com.example.CTGTDL.entity.User;
import com.example.CTGTDL.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser( UserCreationRequest request) {
        User user = new User();
        if (userRepository.existsByName(request.getName()))
            throw  new RuntimeException("User exists");
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    };

    public User getUser(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
