package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String username);

    @Query("SELECT u FROM User u WHERE u.status = true")
    List<User> findAllUserWithActiveStatus();

    List<User> findByFullNameContainingIgnoreCase(String name);

    User findByUserNameAndPassword(String username, String password);

}
