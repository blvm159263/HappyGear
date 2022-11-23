package com.notimplement.happygear.service;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> listAllUserDto();

    List<User> listAllUser();

    UserDto registerAcc(UserDto userDto);

    UserDto loginAcc(UserDto userDto);

    User getUserByUserName(String username);

    List<UserDto> listAllActiveUser();

    UserDto save(UserDto userDto);

    void delete(String username);

    UserDto getUserByName(String name);

    List<UserDto> searchByFullName(String fullname);

}
