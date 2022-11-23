package com.notimplement.happygear.service;

import com.notimplement.happygear.model.dto.RoleDto;

import java.util.List;

public interface RoleService {
    RoleDto getRoleById(Integer id);

    List<RoleDto> listAllRole();

    RoleDto update(RoleDto roleDto);

    RoleDto add(RoleDto roleDto);
}
