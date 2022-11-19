package com.notimplement.happygear.controllers;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userService;

    @GetMapping("/user")
    public List<User> getAllUser(){
        return userService.findAll();
    }
}
