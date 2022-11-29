package com.notimplement.happygear.model.dto;

import java.sql.Date;
import java.util.List;

public class CartDto {
    Date orderDate;
    Double total;
    String username;

    List<CartItemDto> cartItemList;
}
