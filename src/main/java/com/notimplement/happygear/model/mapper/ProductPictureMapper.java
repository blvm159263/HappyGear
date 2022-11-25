package com.notimplement.happygear.model.mapper;

import com.notimplement.happygear.entities.ProductPicture;
import com.notimplement.happygear.model.dto.ProductPictureDto;

public class ProductPictureMapper {
	public static ProductPictureDto toProductPictureDto(ProductPicture pic) {
		ProductPictureDto dto = new ProductPictureDto();
		dto.setPictureId(pic.getPictureId());
		dto.setPictureUrl(pic.getPictureUrl());
		dto.setStatus(pic.getStatus());
		dto.setProductId(pic.getPictureProduct().getProductId());
		return dto;
	}
}
