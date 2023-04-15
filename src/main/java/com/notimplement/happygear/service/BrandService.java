package com.notimplement.happygear.service;

import java.util.List;

import com.notimplement.happygear.model.dto.BrandDto;

public interface BrandService {
	
	List<BrandDto> listAll();
	
	BrandDto getById(Integer id);
	
	BrandDto create(BrandDto b);
	
	BrandDto update(BrandDto b);
	
	BrandDto delete(Integer id);
	
	List<BrandDto> listAllForCus();
	
}
