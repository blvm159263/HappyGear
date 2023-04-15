package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.AccountDto;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.service.UserService;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserApi {

    @Autowired
    private UserService userService;

    @ApiResponse(code = 200, message = "OK")
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
    
    @GetMapping("/")
    public ResponseEntity<?> getAllByPage(@RequestParam("p") Optional<Integer> p){
    	Pageable pageable = PageRequest.of(p.orElse(0), 8);
    	Map<List<UserDto>, Long> listMap = userService.listByPage(pageable);
    	List<Object> list = new ArrayList<>();
    	listMap.forEach((userDtos, count)->{
    		list.add(userDtos);
    		list.add(count);
    	});
    	return ResponseEntity.ok(list);
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
        if(userDto!=null)
            return ResponseEntity.ok(userDto);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDto userDto){
        UserDto user = userService.signupAcc(userDto);
        return ResponseEntity.ok(user);
    }
}
