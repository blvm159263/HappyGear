package com.notimplement.happygear.model.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
	
    private Integer categoryId;
    
    @NotNull(message = "Category name must not be null!!!")
    @Size(min = 2 , max = 20, message = "Name size mus be [2,10]")
    private String categoryName;
    
    private Boolean status;
}
