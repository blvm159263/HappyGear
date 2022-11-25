package com.notimplement.happygear.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandDto {
    private Integer brandId;
    
    @NotNull(message = "Brand name must not be null!!!")
    @Size(min = 2 , max = 10, message = "Name size mus be [2,10]")
    private String brandName;
    
    private Boolean status;
}
