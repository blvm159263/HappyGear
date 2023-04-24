package com.notimplement.happygear.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notimplement.happygear.entities.Category;
import com.notimplement.happygear.model.dto.CategoryDto;
import com.notimplement.happygear.model.mapper.CategoryMapper;
import com.notimplement.happygear.repositories.CategoryRepository;
import com.notimplement.happygear.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository repo;
	
	@Override
	public List<CategoryDto> listAll() {
		List<Category> list = repo.findAll();
		List<CategoryDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(CategoryMapper.toCategoryDto(v)));
		return listDto;
	}

	@Override
	public CategoryDto getById(Integer id) {
		var cate = repo.findById(id).orElse(null);
		if(cate == null) {
			return null;
		}
		return CategoryMapper.toCategoryDto(cate);
	}

	@Override
	public CategoryDto create(CategoryDto b) {
		Category cate = toCategory(b);
		return CategoryMapper.toCategoryDto(repo.save(cate));
	}

	@Override
	public CategoryDto update(CategoryDto b) {
		Category cate = toCategory(b);
		return CategoryMapper.toCategoryDto(repo.save(cate));
	}

	@Override
	public CategoryDto delete(Integer id) {
		Category cate = repo.findById(id).orElse(null);
		if(cate == null) {
			return null;
		}
		cate.setStatus(false);
		return CategoryMapper.toCategoryDto(repo.save(cate));
	}
	
	private Category toCategory(CategoryDto dto) {
		Category cate = new Category();
		cate.setCategoryId(dto.getCategoryId());
		cate.setCategoryName(dto.getCategoryName());
		cate.setStatus(dto.getStatus());
		return cate;
	}

	@Override
	public List<CategoryDto> listAllForCus() {
		List<Category> list = repo.findByStatus(true);
		List<CategoryDto> listDto = new ArrayList<>();
		list.forEach(v -> listDto.add(CategoryMapper.toCategoryDto(v)));
		return listDto;
	}
}
