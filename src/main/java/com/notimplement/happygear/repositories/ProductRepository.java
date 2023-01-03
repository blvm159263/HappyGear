package com.notimplement.happygear.repositories;

import com.notimplement.happygear.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Product findByProductId(Integer id);

    @Query("SELECT p FROM Product p WHERE p.brand.brandId = ?1 " +
            "AND p.proCategory.categoryId = ?2 AND p.price between ?3 AND ?4")
    Page<Product> findAllProductWithFilter(Integer brandId, Integer categoryId,
                                           Double fromPrice, Double toPrice, Pageable pageable);

    @Query(value = "SELECT p.* FROM tbl_product p ORDER BY p.quantity ASC LIMIT 4", nativeQuery = true)
    List<Product> findTop5AndOrderByQuantityAsc();

//    List<Product> findTop4ByQuantityOrOrderByQuantityAsc(Integer quantity);

    @Query(value = "SELECT p.* FROM tbl_product p ORDER BY p.product_id DESC LIMIT 4",nativeQuery = true)
    List<Product> findLatestProduct();

    Page<Product> findByProductNameContainingIgnoreCase(String productName, Pageable pageable);
    
    Page<Product> findByProductNameContaining(String productName, Pageable pageable);
    
}
