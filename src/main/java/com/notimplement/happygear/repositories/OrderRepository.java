package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findByOrderId(Integer id);

    @Query("SELECT o FROM Order o WHERE o.orderUser.username = ?1")
    List<Order> findByUserName(String username);


}
