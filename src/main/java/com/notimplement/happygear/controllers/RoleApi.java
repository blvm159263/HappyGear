package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.RoleDto;
import com.notimplement.happygear.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleApi {

    @Autowired
    private RoleService roleService;

    @GetMapping("")
    public ResponseEntity<?> getAllRole(){
        List<RoleDto> listRole = roleService.getAllRoleDto();
        return ResponseEntity.ok(listRole);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRoleById(@PathVariable Integer id){
        RoleDto roleDto = roleService.getRoleById(id);
        return ResponseEntity.ok(roleDto);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createRole(@RequestBody RoleDto roleDto){
        RoleDto newRoleDto = roleService.createRole(roleDto);
        return ResponseEntity.ok(newRoleDto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteRole(@PathVariable Integer id){
        RoleDto deleteDto = roleService.removeRole(id);
        return ResponseEntity.ok(deleteDto);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateRole(@RequestBody RoleDto roleDto, @PathVariable Integer id){
        RoleDto updateRole = roleService.updateRole(roleDto,id);
        return ResponseEntity.ok(updateRole);
    }
}
