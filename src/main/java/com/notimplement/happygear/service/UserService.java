package com.notimplement.happygear.service;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.AccountDto;
import com.notimplement.happygear.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUserDto();

    List<User> getAllUser();

    UserDto signupAcc(AccountDto accountDto);

    UserDto loginAcc(AccountDto accountDto);

    List<UserDto> getAllActiveUser();

    UserDto saveUser(UserDto userDto);

    UserDto deleteUser(String username);

    UserDto updateUser(UserDto userDto, String username);

    UserDto createUser(UserDto userDto);

    UserDto getByUserName(String name);

    List<UserDto> searchByFullName(String fullname);

}
