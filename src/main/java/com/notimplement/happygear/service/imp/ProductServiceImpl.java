package com.notimplement.happygear.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.repositories.ProductRepository;
import com.notimplement.happygear.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> listAll() {
		return repo.findAll();
	}
	
}
