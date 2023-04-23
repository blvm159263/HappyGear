package com.notimplement.happygear.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testApi {

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("/test")
    public String getProfile() {
        return "Profile: " + profile + "";
    }
}
