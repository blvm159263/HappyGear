package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.Role;
import com.notimplement.happygear.repositories.RoleRepository;
import com.notimplement.happygear.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepo;

    @Override
    public Role getRoleById(long id) {
        return roleRepo.findById(id).orElse(null);
    }
}
