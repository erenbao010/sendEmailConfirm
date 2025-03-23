package com.sendEmailSpringBoot.demo.service;

import com.sendEmailSpringBoot.demo.entity.User;
import com.sendEmailSpringBoot.demo.repository.UserRepository;
import com.sendEmailSpringBoot.demo.request.UserCreationRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User createUser(@NotNull UserCreationRequest request) {
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
    public List<User> getAllUser () {
        return userRepository.findAll();
    }
    public Long getSize () {
        Long count = userRepository.count();
        if (count==0) {
            throw new RuntimeException ("User not found");
        }

        System.out.println(count+"Usserr");
        return count;
    }

    public User updateUser(long id,@NotNull  User user) {
        User existUser = userRepository.findById(id).orElseThrow(()
                -> new RuntimeException("User not exist with" + id));
        existUser.setAge(user.getAge());
        existUser.setName(user.getName());
        existUser.setPassword(user.getPassword());
        return userRepository.save(existUser);

    }
}
