package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Order;
import com.notimplement.happygear.entities.OrderDetail;
import com.notimplement.happygear.model.dto.OrderDetailDto;
import com.notimplement.happygear.model.dto.OrderDto;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderMapper {
    public static OrderDto toOrderDto(Order order){
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
        orderDto.setUserName(order.getOrderUser().getUserName());
        orderDto.setDate((Date) order.getDate());
        orderDto.setTotal(order.getTotal());
        orderDto.setStatus(order.getStatus());
        Set<OrderDetailDto> detailDtoSet = new HashSet<>();
        Set<OrderDetail> details = new HashSet<>();
        details.addAll(order.getOrderDetailSet());
        details.forEach(v -> detailDtoSet.add(OrderDetailMapper.toOrderDetailDto(v)));
        return orderDto;
    }
}
