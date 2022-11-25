package com.notimplement.happygear.service;

import java.util.List;
import com.notimplement.happygear.model.dto.CategoryDto;

public interface CategoryService {
	
	List<CategoryDto> listAll();
	
	CategoryDto getById(Integer id);
	
	CategoryDto create(CategoryDto c);
	
	CategoryDto update(CategoryDto c);
	
	CategoryDto delete(Integer id);
	
	List<CategoryDto> listAllForCus();
}
