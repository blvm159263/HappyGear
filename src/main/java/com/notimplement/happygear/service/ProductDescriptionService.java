package com.notimplement.happygear.service;

import java.util.List;

import com.notimplement.happygear.model.dto.ProductDescriptionDto;

public interface ProductDescriptionService {
	
	List<ProductDescriptionDto> listAll();

	ProductDescriptionDto getById(Integer id);

	ProductDescriptionDto create(ProductDescriptionDto d);

	ProductDescriptionDto update(ProductDescriptionDto d);

//	ProductDescriptionDto delete(Integer id);
	
	
}
