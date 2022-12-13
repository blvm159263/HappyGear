package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByProductId(Integer id);

    @Query("SELECT p FROM Product p WHERE p.brand.brandId = ?1 " +
            "AND p.proCategory.categoryId = ?2 AND p.price between ?3 AND ?4")
    Page<Product> findAllProductWithFilter(Integer brandId, Integer categoryId,
                                           Double fromPrice, Double toPrice, Pageable pageable);
}
