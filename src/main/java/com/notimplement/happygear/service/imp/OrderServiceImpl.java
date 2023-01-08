package com.notimplement.happygear.service.imp;

import com.notimplement.happygear.entities.Order;
import com.notimplement.happygear.model.dto.OrderDto;
import com.notimplement.happygear.model.enums.OrderStatus;
import com.notimplement.happygear.model.mapper.OrderMapper;
import com.notimplement.happygear.repositories.OrderRepository;
import com.notimplement.happygear.repositories.UserRepository;
import com.notimplement.happygear.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<OrderDto> getAllOrderDto() {
        return orderRepository.findAll()
                .stream().map(OrderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public List<OrderDto> getByUserName(String username) {
        return orderRepository.findByUserName(username)
                .stream().map(OrderMapper::toOrderDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto getByOrderId(Integer id) {
        Order order = orderRepository.findByOrderId(id);
        return OrderMapper.toOrderDto(order);
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        if(orderDto!=null){
            Order order = toOrder(orderDto);
            orderRepository.save(order);
            return OrderMapper.toOrderDto(order);
        }
        return null;
    }

    @Override
    public OrderDto create(OrderDto orderDto) {
        if(orderDto!=null) {
            Order order = toOrder(orderDto);
            orderRepository.save(order);
            return OrderMapper.toOrderDto(order);
        }
        return null;
    }

    @Override
    public OrderDto delete(Integer id) {
        Order order = orderRepository.findByOrderId(id);
        order.setStatus(OrderStatus.CANCEL.getAction());
        return OrderMapper.toOrderDto(orderRepository.save(order));
    }

    private Order toOrder(OrderDto orderDto){
        Order order = new Order();
        order.setOrderId(orderDto.getOrderId());
        order.setDate(orderDto.getDate());
        order.setTotal(orderDto.getTotal());
        order.setStatus(orderDto.getStatus());
        order.setOrderUser(userRepository.findByUsername(orderDto.getUserName()).orElseThrow());
        return order;
    }
}
