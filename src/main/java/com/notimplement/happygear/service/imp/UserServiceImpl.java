package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.model.mapper.UserMapper;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;
    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserDto> listAllUserDto() {
        return userRepo.findAll().stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public List<User> listAllUser() {
        return userRepo.findAll();
    }

    @Override
    public UserDto registerAcc(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto loginAcc(UserDto userDto) {
        return null;
    }

    @Override
    public User getUserByUserName(String username) {
        return userRepo.findByUserName(username);
    }

    @Override
    public List<UserDto> listAllActiveUser() {
        return userRepo.findAllUserWithActiveStatus().stream().map(userMapper::toUserDto).collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto delete(String username) {
        return null;
    }

    @Override
    public UserDto getUserByName(String name) {
        return null;
    }

    @Override
    public List<UserDto> searchByFullName(String fullname) {
        return null;
    }
}
