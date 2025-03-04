package com.sendEmailSpringBoot.demo.service;


import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.repository.UserRepository;
import com.sendEmailSpringBoot.demo.request.UserCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(UserCreationRequest request) {
        User user = new User();


        if (userRepository.existsByName(request.getName()))
            throw new RuntimeException("User exists");
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    public User getUser(long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
