package com.sendEmailSpringBoot.demo.request;

import com.sendEmailSpringBoot.demo.validator.AgeValidation;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UserCreationRequest {
    private int id;
    @Size(min = 3, message = "Username must be at least 3 characters")
    private String name;


    @AgeValidation(min = 18, message = "Age must be at least 18 years old")
    private String age;

    @Size(min=8, message = "Password required must be at least 8 characters")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
