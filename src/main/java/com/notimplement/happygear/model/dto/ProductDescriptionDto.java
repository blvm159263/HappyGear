package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescriptionDto {
    private long descriptionId;
    private long productId;
    private long categoryId;
    private String keycap;
    private String switchKeyBoard;
    private String connect;
    private String led;
    private String freigh;
    private String itemDimension;
    private String cpu;
    private String ram;
    private String opertingSystem;
    private String battery;
    private String hardDisk;
    private String graphicCard;
    private String keyBoard;
    private String audio;
    private String wifi;
    private String bluetooth;
    private String color;
    private String frameRate;
    private String screenSize;
    private String screenType;
}
