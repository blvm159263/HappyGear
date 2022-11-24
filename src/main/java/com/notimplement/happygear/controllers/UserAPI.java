package com.notimplement.happygear.controllers;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAPI {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllUser(){
        List<UserDto> listUser = userService.getAllActiveUser();
        if(listUser.size()>0){
            return new ResponseEntity<>(listUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(listUser,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUserName(@PathVariable(name = "username") String username){
        UserDto userDto = userService.getByUserName(username);
        if(userDto!=null)
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        return new ResponseEntity<>(username,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        UserDto newUserDto = userService.createUser(userDto);
        if(newUserDto!=null)
            return new ResponseEntity<>(newUserDto, HttpStatus.CREATED);
        return new ResponseEntity<>(userDto.getUserName(), HttpStatus.CONFLICT);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "username") String username){
        UserDto deletedUserDto = userService.deleteUser(username);
        if(!deletedUserDto.getStatus())
            return new ResponseEntity<>(deletedUserDto,HttpStatus.OK);
        return new ResponseEntity<>(username,HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody UserDto userDto){
        UserDto updateUserDto = userService.updateUser(userDto);
        if(userDto!=null){
            return new ResponseEntity<>(updateUserDto,HttpStatus.OK);
        }
        return new ResponseEntity<>(userDto.getUserName(),HttpStatus.NOT_FOUND);
    }
}
