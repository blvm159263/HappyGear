package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/**
A DTO (Data Transfer Object) representing a single item in a shopping cart.
@Data
@AllArgsConstructor
@NoArgsConstructor public class CartItemDto {
The ID of the product associated with this cart item.
*/
public class CartItemDto {
    private Integer productId;
    private Integer quantity;
    private Double price;
}
