package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.BrandDto;
import com.notimplement.happygear.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/brands")
public class BrandApi {

	@Autowired
	BrandService service;
	
	@GetMapping("")
	public ResponseEntity<?> listAllBrand(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getBrandById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createBrand(@Valid @RequestBody BrandDto brand){
		return ResponseEntity.ok(service.create(brand));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBrand(@PathVariable(name ="id") Integer id ,@Valid @RequestBody BrandDto brand){
		brand.setBrandId(id);
		return ResponseEntity.ok(service.update(brand));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBrand(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.delete(id));
	}
	
	@GetMapping("/customer")
	public ResponseEntity<?> listAllForCus(){
		return ResponseEntity.ok(service.listAllForCus());
	}
}
