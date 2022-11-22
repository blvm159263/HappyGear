package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPictureDto {
    private long pictureId;
    private String pictureUrl;
    private long productId;
    private boolean status;
}
