package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Role;
import com.notimplement.happygear.model.dto.RoleDto;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public static RoleDto toRoleDTO(Role role){
        RoleDto dto = new RoleDto();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        dto.setStatus(role.getStatus());
        return dto;
    }
}
