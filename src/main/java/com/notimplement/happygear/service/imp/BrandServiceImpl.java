package com.notimplement.happygear.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notimplement.happygear.entities.Brand;
import com.notimplement.happygear.model.dto.BrandDto;
import com.notimplement.happygear.model.mapper.BrandMapper;
import com.notimplement.happygear.repositories.BrandRepository;
import com.notimplement.happygear.service.BrandService;


@Service
@Transactional
public class BrandServiceImpl implements BrandService{

	@Autowired
	BrandRepository repo;
	
	@Override
	public List<BrandDto> listAll() {
		List<Brand> list = repo.findAll();
		List<BrandDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(BrandMapper.toBrandDto(v)));
		return listDto;
	}

	@Override
	public BrandDto getById(Integer id) {
		return BrandMapper.toBrandDto(repo.findById(id).get());
	}

	@Override
	public BrandDto create(BrandDto b) {
		Brand brand = toBrand(b);
		return BrandMapper.toBrandDto(repo.save(brand));
	}

	@Override
	public BrandDto update(BrandDto b) {
		Brand brand = toBrand(b);
		return BrandMapper.toBrandDto(repo.save(brand));
	}

	@Override
	public BrandDto delete(Integer id) {
		Brand brand = repo.findById(id).get();
		brand.setStatus(false);
		return BrandMapper.toBrandDto(repo.save(brand));
	}
	
	private Brand toBrand(BrandDto dto) {
		Brand brand = new Brand();
		brand.setBrandId(dto.getBrandId());
		brand.setBrandName(dto.getBrandName());
		brand.setStatus(dto.getStatus());
		return brand;
	}

	@Override
	public List<BrandDto> listAllForCus() {
		List<Brand> list = repo.findByStatus(true);
		List<BrandDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(BrandMapper.toBrandDto(v)));
		return listDto;
	}
}
