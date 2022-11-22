package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.OrderDetail;
import com.notimplement.happygear.model.dto.OrderDetailDto;

public class OrderDetailMapper {
    public static OrderDetailDto toOrderDetailDto(OrderDetail orderDetail){
        OrderDetailDto dto = new OrderDetailDto();
        dto.setDetailId(orderDetail.getDetailId());
        dto.setOrderId(orderDetail.getOrder().getOrderId());
        dto.setPrice(orderDetail.getPrice());
        dto.setQuantity(orderDetail.getQuantity());
        dto.setStatus(orderDetail.getStatus());
        dto.setProductId(orderDetail.getProduct().getProductId());
        return dto;
    }
}
