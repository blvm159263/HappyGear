package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTO toUserDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUsername(user.getUsername());
        dto.setAge(user.getAge());
        dto.setAddress(user.getAddress());
        dto.setEmail(user.getEmail());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setStatus(user.isStatus());
        dto.setGender(user.isGender());
        dto.setRoleId(user.getRole().getRoleId());
        return dto;
    }
}
