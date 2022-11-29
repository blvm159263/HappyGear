package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.OrderDto;
import com.notimplement.happygear.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

@RestController
@RequestMapping("/api/orders")
public class OrderApi {

    @Autowired
    OrderService orderService;

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
    public ResponseEntity<?> createOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.create(orderDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable Integer id){
        return ResponseEntity.ok(orderService.delete(id));
    }
}
