package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByUserName(String id) {
        return userRepo.findByUserName(id);
    }

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepo.deleteUserByUserName(username);
    }
}
