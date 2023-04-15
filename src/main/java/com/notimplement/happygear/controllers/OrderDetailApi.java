package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.OrderDetailDto;
import com.notimplement.happygear.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order-detail")
public class OrderDetailApi {

    @Autowired
    OrderDetailService orderDetailService;

    @GetMapping("")
    public ResponseEntity<?> getAllOrderDetail(){
        return ResponseEntity.ok(orderDetailService.getAllOrderDetailDto());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable Integer id){
        return ResponseEntity.ok(orderDetailService.getByDetailId(id));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateOrderDetail(@RequestBody OrderDetailDto orderDetailDto){
        return ResponseEntity.ok(orderDetailService.update(orderDetailDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrderDetail(@PathVariable Integer id){
        return ResponseEntity.ok(orderDetailService.delete(id));
    }
}
