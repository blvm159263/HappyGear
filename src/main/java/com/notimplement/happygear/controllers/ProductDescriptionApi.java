package com.notimplement.happygear.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notimplement.happygear.model.dto.ProductDescriptionDto;
import com.notimplement.happygear.service.ProductDescriptionService;

@RestController
@RequestMapping("api/descriptions")
public class ProductDescriptionApi {
	@Autowired
	ProductDescriptionService service;
	
	@GetMapping("")
	public ResponseEntity<?> listAllProductDescription(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductDescriptionById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createProductDescription(@Valid @RequestBody ProductDescriptionDto ProductDescription){
		return ResponseEntity.ok(service.create(ProductDescription));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProductDescription(@PathVariable(name ="id") Integer id ,@Valid @RequestBody ProductDescriptionDto p){
		p.setProductId(id);
		return ResponseEntity.ok(service.update(p));
	}
	
//	@DeleteMapping("/delete/{id}")
//	public ResponseEntity<?> deleteProductDescription(@PathVariable(name ="id") Integer id){
//		return ResponseEntity.ok(service.delete(id));
//	}
}
