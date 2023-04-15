package com.notimplement.happygear.service;

import com.notimplement.happygear.entities.OrderDetail;
import com.notimplement.happygear.model.dto.CartItemDto;
import com.notimplement.happygear.model.dto.OrderDetailDto;

import java.util.List;

public interface OrderDetailService {
    List<OrderDetailDto> getAllOrderDetailDto();

    List<OrderDetail> getAllOrderDetail();

    OrderDetailDto getByDetailId(Integer id);

    List<OrderDetailDto> getAllByOrderId(Integer id);

    List<OrderDetailDto> getAllByProductId(Integer id);

    OrderDetailDto create(OrderDetailDto orderDetailDto);

    OrderDetailDto update(OrderDetailDto orderDetailDto);

    OrderDetailDto delete(Integer id);

    Double getCartAmount(List<CartItemDto> list);
}
