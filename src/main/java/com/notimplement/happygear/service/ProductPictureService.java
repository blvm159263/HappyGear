package com.notimplement.happygear.service;

import java.util.List;

import com.notimplement.happygear.model.dto.ProductPictureDto;

public interface ProductPictureService {
	List<ProductPictureDto> listAll();

	ProductPictureDto getById(Integer id);

	ProductPictureDto create(ProductPictureDto pic);

	ProductPictureDto update(ProductPictureDto pic);

	ProductPictureDto delete(Integer id);
	
	List<ProductPictureDto> listByProductIdAndStatus(Integer id, Boolean status);
	
	ProductPictureDto getByProductId(Integer id);
}
