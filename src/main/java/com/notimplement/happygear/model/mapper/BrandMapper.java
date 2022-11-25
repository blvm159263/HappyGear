package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Brand;
import com.notimplement.happygear.model.dto.BrandDto;

public class BrandMapper {
	public static BrandDto toBrandDto(Brand brand) {
		BrandDto dto = new BrandDto();
		dto.setBrandId(brand.getBrandId());
		dto.setBrandName(brand.getBrandName());
		dto.setStatus(brand.getStatus());
		return dto;
	}
}
