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

import com.notimplement.happygear.model.dto.ProductDto;
import com.notimplement.happygear.service.ProductService;


@RestController
@RequestMapping("api/products")
public class ProductApi {

	@Autowired
	ProductService service;
	
	@GetMapping("")
	public ResponseEntity<?> listAllProduct(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDto Product){
		return ResponseEntity.ok(service.create(Product));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable(name ="id") Integer id ,@Valid @RequestBody ProductDto p){
		p.setProductId(id);
		return ResponseEntity.ok(service.update(p));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.delete(id));
	}
	
}
