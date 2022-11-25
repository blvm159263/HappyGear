package com.notimplement.happygear.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.notimplement.happygear.entities.ProductDescription;

public interface ProductDescriptionRepository extends JpaRepository<ProductDescription, Integer>{
	
}
