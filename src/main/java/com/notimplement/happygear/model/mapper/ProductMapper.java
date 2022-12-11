package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.model.dto.ProductDto;

public class ProductMapper {
	public static ProductDto toProductDto(Product p) {
		ProductDto dto = new ProductDto();
		dto.setProductId(p.getProductId());
		dto.setProductName(p.getProductName());
		dto.setPrice(p.getPrice());
		dto.setQuantity(p.getQuantity());
		dto.setInsuranceInfo(p.getInsuranceInfo());
		dto.setStatus(p.getStatus());
		dto.setCategoryId(p.getProCategory().getCategoryId());
		dto.setBrandId(p.getBrand().getBrandId());
		dto.setPicture(p.getPicture());
		return dto;
	}
}
