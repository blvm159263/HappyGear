package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static UserDto toUserDto(User user) {
        if(user!=null){
            UserDto dto = new UserDto();
            dto.setUsername(user.getUsername());
            dto.setPassword(user.getPassword());
            dto.setFullName(user.getFullName());
            dto.setAddress(user.getAddress());
            dto.setEmail(user.getEmail());
            dto.setPhoneNumber(user.getPhoneNumber());
            dto.setStatus(user.getStatus());
            dto.setGender(user.getGender());
            dto.setRoleId(user.getRole().getRoleId());
            return dto;
        }
        return null;
    }
}
