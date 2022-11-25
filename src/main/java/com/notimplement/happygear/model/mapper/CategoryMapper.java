package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.Category;
import com.notimplement.happygear.model.dto.CategoryDto;

public class CategoryMapper {
	public static CategoryDto toCategoryDto(Category cate) {
		CategoryDto dto = new CategoryDto();
		dto.setCategoryId(cate.getCategoryId());
		dto.setCategoryName(cate.getCategoryName());
		dto.setStatus(cate.getStatus());
		return dto;
	}
}
