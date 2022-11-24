package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.Role;
import com.notimplement.happygear.model.dto.RoleDto;
import com.notimplement.happygear.model.mapper.RoleMapper;
import com.notimplement.happygear.repositories.RoleRepository;
import com.notimplement.happygear.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public RoleDto getRoleById(Integer id) {
        Role role = roleRepo.findByRoleId(id);
        if(role!=null){
            return RoleMapper.toRoleDTO(role);
        }
        return null;
    }

    @Override
    public List<RoleDto> getAllRoleDto() {
        List<Role> listRole = roleRepo.findAll();
        List<RoleDto> listRoleDto = new ArrayList<>();
        listRole.forEach(r -> listRoleDto.add(RoleMapper.toRoleDTO(r)));
        return listRoleDto;
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, Integer id) {
        Role role = roleRepo.findByRoleId(id);
        if(role!=null){
            RoleDto roledto = new RoleDto();
            roledto.setRoleId(roleDto.getRoleId());
            roledto.setRoleName(roleDto.getRoleName());
            roledto.setStatus(roleDto.getStatus());
            return roledto;
        }
        return null;
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = toRole(roleDto);
        roleRepo.save(role);
        return RoleMapper.toRoleDTO(role);
    }

    @Override
    public RoleDto removeRole(Integer id) {
        Optional<Role> role = roleRepo.findById(id);
        if(role.isPresent()){
            RoleDto roledto = new RoleDto();
            roledto.setRoleId(role.get().getRoleId());
            roledto.setRoleName(role.get().getRoleName());
            roledto.setStatus(false);
            return roledto;
        }
        return null;
    }

    private Role toRole(RoleDto roleDto){
        if(roleDto!=null){
            Role role = new Role();
            role.setRoleId(roleDto.getRoleId());
            role.setRoleName(roleDto.getRoleName());
            role.setStatus(roleDto.getStatus());
            return role;
        }
        return null;
    }
}
