package com.notimplement.happygear.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.notimplement.happygear.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
}
