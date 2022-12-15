package com.notimplement.happygear.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.entities.ProductPicture;
import com.notimplement.happygear.model.dto.ProductPictureDto;
import com.notimplement.happygear.model.mapper.ProductPictureMapper;
import com.notimplement.happygear.repositories.ProductPictureRepository;
import com.notimplement.happygear.repositories.ProductRepository;
import com.notimplement.happygear.service.ProductPictureService;

@Service
@Transactional
public class ProductPictureServiceImpl implements ProductPictureService{
	
	@Autowired
	ProductPictureRepository repo;
	@Autowired
	ProductRepository productRepo;
	
	@Override
	public List<ProductPictureDto> listAll() {
		List<ProductPicture> list = repo.findAll();
		List<ProductPictureDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(ProductPictureMapper.toProductPictureDto(v)));
		return listDto;
	}

	@Override
	public ProductPictureDto getById(Integer id) {
		return ProductPictureMapper.toProductPictureDto(repo.findById(id).get());
	}

	@Override
	public ProductPictureDto create(ProductPictureDto b) {
		ProductPicture pic = toProductPicture(b);
		return ProductPictureMapper.toProductPictureDto(repo.save(pic));
	}

	@Override
	public ProductPictureDto update(ProductPictureDto b) {
		ProductPicture pic = toProductPicture(b);
		return ProductPictureMapper.toProductPictureDto(repo.save(pic));
	}

	@Override
	public ProductPictureDto delete(Integer id) {
		ProductPicture pic = repo.findById(id).get();
		pic.setStatus(false);
		return ProductPictureMapper.toProductPictureDto(repo.save(pic));
	}
	
	private ProductPicture toProductPicture(ProductPictureDto dto) {
		ProductPicture pic = new ProductPicture();
		pic.setPictureId(dto.getPictureId());
		pic.setPictureUrl(dto.getPictureUrl());
		pic.setStatus(dto.getStatus());
		pic.setPictureProduct(getProductById(dto.getProductId()));
		return pic;
	}
	
	private Product getProductById(Integer id) {
		return productRepo.findById(id).get();
	}

	@Override
	public List<ProductPictureDto> listByProductIdAndStatus(Integer id, Boolean status) {
		List<ProductPicture> list = repo.findByPictureProductAndStatus(getProductById(id), status);
		List<ProductPictureDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(ProductPictureMapper.toProductPictureDto(v)));
		return listDto;
	}

	@Override
	public ProductPictureDto getByProductId(Integer id) {
		ProductPicture picture = repo.getMainByProductId(id);
		return ProductPictureMapper.toProductPictureDto(picture);
	}
}
