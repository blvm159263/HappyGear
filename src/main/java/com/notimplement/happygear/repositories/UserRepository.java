package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);
    void deleteUserByUserName(String username);
    List<User> findAllByFullName(String fullname);
}
