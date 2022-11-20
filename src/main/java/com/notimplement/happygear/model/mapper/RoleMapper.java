package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Role;
import com.notimplement.happygear.model.dto.RoleDTO;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {
    public RoleDTO toRoleDTO(Role role){
        RoleDTO dto = new RoleDTO();
        dto.setRoleId(role.getRoleId());
        dto.setRoleName(role.getRoleName());
        dto.setStatus(role.isStatus());
        return dto;
    }
}
