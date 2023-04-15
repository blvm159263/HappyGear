package com.notimplement.happygear.service;

import java.util.List;
import java.util.Map;

import com.notimplement.happygear.model.dto.ProductDto;
import org.springframework.data.domain.Pageable;

public interface ProductService {

	List<ProductDto> listAll();

	Map<List<ProductDto>, Integer> listByPage(Pageable pageable);

	Map<List<ProductDto>, Integer> listByPageCategoryAndBrand(Integer brandId, Integer categoryId, Double fromPrice,
			Double toPrice, Pageable pageable);

	List<ProductDto> listAllProductWithMinQuantity();

	List<ProductDto> listAllLatestProduct();

	ProductDto getById(Integer id);

	ProductDto create(ProductDto pic);

	ProductDto update(ProductDto pic);

	ProductDto delete(Integer id);

	Map<List<ProductDto>, Integer> listProductByName(String name, Pageable pageable);
	Long totalProduct();

	Map<List<ProductDto>, Long> listByPageAndName(String productName, Pageable pageable);
}
