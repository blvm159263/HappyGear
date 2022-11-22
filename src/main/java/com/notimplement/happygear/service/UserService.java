package com.notimplement.happygear.service;

import com.notimplement.happygear.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUser();
    User getUserByUserName(String id);
    void saveUser(User user);
    void deleteUser(String username);
}
