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

import com.notimplement.happygear.model.dto.ProductPictureDto;
import com.notimplement.happygear.service.ProductPictureService;

@RestController
@RequestMapping("api/pictures")
public class ProductPictureApi {
	@Autowired
	ProductPictureService service;
	
	@GetMapping("")
	public ResponseEntity<?> listAllProductPicture(){
		return ResponseEntity.ok(service.listAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getPictureById(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.getById(id));
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<?> getPictureByProductId(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.listByProductIdAndStatus(id,true));
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createProductPicture(@Valid @RequestBody ProductPictureDto ProductPicture){
		return ResponseEntity.ok(service.create(ProductPicture));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateProductPicture(@PathVariable(name ="id") Integer id ,@Valid @RequestBody ProductPictureDto p){
		p.setPictureId(id);
		return ResponseEntity.ok(service.update(p));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductPicture(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.delete(id));
	}
}
