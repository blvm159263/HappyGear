package com.notimplement.happygear.controllers;

import com.notimplement.happygear.entities.User;
import com.notimplement.happygear.model.dto.OrderDto;
import com.notimplement.happygear.model.dto.RequestOrderDto;
import com.notimplement.happygear.model.dto.UserDto;
import com.notimplement.happygear.service.OrderDetailService;
import com.notimplement.happygear.service.OrderService;
import com.notimplement.happygear.service.UserService;
import com.notimplement.happygear.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@RestController
@RequestMapping("/api/orders")
@Slf4j
public class OrderApi {

    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    UserService userService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrder(){
        return ResponseEntity.ok(orderService.getAllOrderDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderByOrderId(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.getByOrderId(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.update(orderDto));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody RequestOrderDto order){
        log.info("Request " + order.toString());
        OrderDto orderDto = new OrderDto();

        Double amount = orderDetailService.getCartAmount(order.getCartItems());
        UserDto userDto = userService.getByUserName(order.getUserName());

        if(userDto!=null){
            orderDto.setUserName(userDto.getUserName());
            log.info("User with username: " + userDto.getUserName());
        }
        else{
            log.info("User is not exist");
        }
        orderDto.setDate(Date.valueOf("2022-12-05"));
        orderDto.setUserName(userDto.getUserName());
        orderDto.setTotal(amount);
        orderDto.setStatus(1);
        orderService.create(orderDto);
        log.info("order push........");
        return ResponseEntity.ok(orderService.create(orderDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.delete(id));
    }
}
