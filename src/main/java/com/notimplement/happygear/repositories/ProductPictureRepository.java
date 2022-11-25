package com.notimplement.happygear.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notimplement.happygear.entities.Product;
import com.notimplement.happygear.entities.ProductPicture;

public interface ProductPictureRepository extends JpaRepository<ProductPicture, Integer>{
	
	List<ProductPicture> findByPictureProductAndStatus(Product pictureProduct, Boolean status);
	
}
