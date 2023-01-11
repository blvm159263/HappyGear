package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    @Query("SELECT u FROM User u WHERE u.status = true")
    List<User> findAllUserWithActiveStatus();

    List<User> findByFullNameContainingIgnoreCase(String name);

    User findByUsernameAndPassword(String username, String password);
    
    Optional<User> findByUsername(String username);

}
