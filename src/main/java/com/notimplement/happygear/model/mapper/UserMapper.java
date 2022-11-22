package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toUserDto(User user){
        UserDto dto = new UserDto();
        dto.setUserName(user.getUserName());
        dto.setPassword(user.getPassword());
        dto.setFullName(user.getFullName());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setStatus(user.isStatus());
        dto.setGender(user.isGender());
        dto.setRoleId(user.getRole().getRoleId());
        return dto;
    }
}
