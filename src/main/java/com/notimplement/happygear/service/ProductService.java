package com.notimplement.happygear.service;

import java.util.List;

import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.model.dto.ProductDto;
import org.springframework.data.domain.Pageable;

public interface ProductService {
	
	List<ProductDto> listAll();

	List<ProductDto> listByPage(Pageable pageable);

	ProductDto getById(Integer id);

	ProductDto create(ProductDto pic);

	ProductDto update(ProductDto pic);

	ProductDto delete(Integer id);
}
