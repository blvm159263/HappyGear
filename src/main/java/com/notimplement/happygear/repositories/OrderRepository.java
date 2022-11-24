package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
