package com.notimplement.happygear.controllers;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDTO;
import com.notimplement.happygear.model.mapper.UserMapper;
import com.notimplement.happygear.service.RoleService;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> listUser = userService.getAllUser().stream().map(userMapper::toUserDTO).collect(Collectors.toList());
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserByUserId(@PathVariable(name = "id") String id){
        User user = userService.getUserByUserName(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/user/save")
    public ResponseEntity<User> saveUser(UserDTO userDTO){
        User savedUser = new User();
        savedUser.setUserName(userDTO.getUserName());
        savedUser.setFullName(userDTO.getFullName());
        savedUser.setPassword(userDTO.getPassword());
        savedUser.setPassword(userDTO.getPassword());
        savedUser.setAddress(userDTO.getAddress());
        savedUser.setEmail(userDTO.getEmail());
        savedUser.setPhoneNumber(userDTO.getPhoneNumber());
        savedUser.setGender(userDTO.isGender());
        savedUser.setStatus(userDTO.isStatus());
        savedUser.setRole(roleService.getRoleById(userDTO.getRoleId()));
        userService.saveUser(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id") String id){
        User user = userService.getUserByUserName(id);
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
