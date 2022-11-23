package com.notimplement.happygear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notimplement.happygear.entities.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
