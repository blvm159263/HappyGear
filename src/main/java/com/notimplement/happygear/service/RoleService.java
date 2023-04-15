package com.notimplement.happygear.service;

import com.notimplement.happygear.model.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getRoleById(Integer id);

    List<RoleDto> getAllRoleDto();

    RoleDto updateRole(RoleDto roleDto, Integer id);

    RoleDto createRole(RoleDto roleDto);

    RoleDto removeRole(Integer id);
}
