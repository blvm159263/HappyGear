package com.notimplement.happygear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notimplement.happygear.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	
}
