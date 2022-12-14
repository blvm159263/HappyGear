package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.AccountDto;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        List<UserDto> listUser = userService.getAllActiveUser();
        return ResponseEntity.ok(listUser);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUserName(@PathVariable(name = "username") String username){
        UserDto userDto = userService.getByUserName(username);
        if(userDto==null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        UserDto newUserDto = userService.createUser(userDto);
        return ResponseEntity.ok(newUserDto);
    }

    @DeleteMapping("/delete/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "username") String username){
        UserDto deletedUserDto = userService.deleteUser(username);
        return ResponseEntity.ok(deletedUserDto);
    }

    @PutMapping("/update/{username}")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable(name = "username") String username){
        UserDto updateUserDto = userService.updateUser(userDto, username);
        return ResponseEntity.ok(updateUserDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AccountDto accountDto){
        UserDto userDto = userService.loginAcc(accountDto);
        return ResponseEntity.ok(userDto);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        UserDto user = userService.signupAcc(userDto);
        return ResponseEntity.ok(user);
    }
}
