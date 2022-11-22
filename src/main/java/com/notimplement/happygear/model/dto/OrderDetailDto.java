package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private long detailId;
    private long orderId;
    private double price;
    private int quantity;
    private boolean status;
    private long productId;
}
