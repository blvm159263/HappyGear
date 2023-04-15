package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Order;
import com.notimplement.happygear.model.dto.OrderDto;

public class OrderMapper {
    public static OrderDto toOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setUserName(order.getOrderUser().getUsername());
        orderDto.setDate(order.getDate());
        orderDto.setTotal(order.getTotal());
        orderDto.setStatus(order.getStatus());
        return orderDto;
    }
}
