package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRoleId(Integer id);
}
