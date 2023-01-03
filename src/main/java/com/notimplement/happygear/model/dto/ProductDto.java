package com.notimplement.happygear.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

	private Integer productId;

	@NotNull(message = "Product name must not be null!!!")
	@Size(min = 5, message = "Name must more then 5 characters!!!")
	private String productName;

	@Min(0)
	@NotNull(message = "Price must not be null!!!")
	private Double price;

	@Min(0)
	@NotNull(message = "Quantity must not be null!!!")
	private Integer quantity;

	@NotNull
	private String insuranceInfo;

	
	private String picture;

	private Boolean status;

	@NotNull
	private Integer categoryId;

	@NotNull
	private Integer brandId;
}
