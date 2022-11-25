package com.notimplement.happygear.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notimplement.happygear.entities.Brand;
import com.notimplement.happygear.entities.Category;
import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.model.dto.ProductDto;
import com.notimplement.happygear.model.mapper.ProductMapper;
import com.notimplement.happygear.repositories.BrandRepository;
import com.notimplement.happygear.repositories.CategoryRepository;
import com.notimplement.happygear.repositories.ProductRepository;
import com.notimplement.happygear.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;
	@Autowired
	BrandRepository brandRepo;
	@Autowired
	CategoryRepository cateRepo;
	
	@Override
	public List<ProductDto> listAll() {
		List<Product> list = repo.findAll();
		List<ProductDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(ProductMapper.toProductDto(v)));
		return listDto;
	}

	@Override
	public ProductDto getById(Integer id) {
		return ProductMapper.toProductDto(repo.findById(id).get());
	}

	@Override
	public ProductDto create(ProductDto b) {
		Product p = toProduct(b);
		return ProductMapper.toProductDto(repo.save(p));
	}

	@Override
	public ProductDto update(ProductDto b) {
		Product p = toProduct(b);
		return ProductMapper.toProductDto(repo.save(p));
	}

	@Override
	public ProductDto delete(Integer id) {
		Product p = repo.findById(id).get();
		p.setStatus(false);
		return ProductMapper.toProductDto(repo.save(p));
	}
	
	private Product toProduct(ProductDto dto) {
		Product p = new Product();
		p.setProductId(dto.getProductId());
		p.setProductName(dto.getProductName());
		p.setPrice(dto.getPrice());
		p.setQuantity(dto.getQuantity());
		p.setInsuranceInfo(dto.getInsuranceInfo());
		p.setStatus(dto.getStatus());
		p.setProCategory(getCateById(dto.getCategoryId()));
		p.setBrand(getBrandById(dto.getBrandId()));
		return p;
	}
	
	private Category getCateById(Integer id) {
		return cateRepo.findById(id).get();
	}
	
	private Brand getBrandById(Integer id) {
		return brandRepo.findById(id).get();
	}
	
}
