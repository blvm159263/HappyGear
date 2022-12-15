package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Integer> {

    OrderDetail findByDetailId(Integer id);

    @Query("SELECT od FROM OrderDetail od WHERE od.order.orderId = ?1")
    List<OrderDetail> findAllByOrderId(Integer id);

    @Query("SELECT od FROM OrderDetail od WHERE od.orderdetailProduct.productId = ?1")
    List<OrderDetail> findAllByProductId(Integer id);
}
