package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPictureDto {
    private Integer pictureId;
    private String pictureUrl;
    private Integer productId;
    private boolean status;
}
