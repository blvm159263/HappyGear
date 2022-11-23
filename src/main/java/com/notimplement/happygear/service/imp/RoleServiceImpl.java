package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.model.dto.RoleDto;
import com.notimplement.happygear.model.mapper.RoleMapper;
import com.notimplement.happygear.repositories.RoleRepository;
import com.notimplement.happygear.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public RoleDto getRoleById(Integer id) {
        return roleMapper.toRoleDTO(roleRepo.findById(id).get());
    }

    @Override
    public List<RoleDto> listAllRole() {
        return null;
    }

    @Override
    public RoleDto update(RoleDto roleDto) {
        return null;
    }

    @Override
    public RoleDto add(RoleDto roleDto) {
        return null;
    }
}
