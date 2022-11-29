package com.notimplement.happygear.service;

import com.notimplement.happygear.entities.Order;
import com.notimplement.happygear.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAllOrderDto();

    List<Order> getAllOrder();

    List<OrderDto> getByUserName(String username);

    OrderDto getByOrderId(Integer id);

    OrderDto update(OrderDto order);

    OrderDto create(OrderDto order);

    OrderDto delete(Integer id);
}
