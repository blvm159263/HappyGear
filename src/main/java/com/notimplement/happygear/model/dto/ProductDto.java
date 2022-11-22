package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private long productId;
    private String productName;
    private double price;
    private int quantity;
    private String insuranceInfo;
    private boolean status;
    private long categoryId;
    private long brandId;
}
