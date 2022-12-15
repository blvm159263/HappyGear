package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.ProductPictureDto;
import com.notimplement.happygear.service.ProductPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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

	@GetMapping("/productPic/{productId}")
	public ResponseEntity<?> getProductPictureByProductId(@PathVariable(name = "productId") Integer id){
		List<ProductPictureDto> list = service.listByProductIdAndStatus(id,true);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/product-main/{productId}")
	public ResponseEntity<?> getMainPictureByProductId(@PathVariable(name = "productId") Integer id){
		ProductPictureDto pic = service.getByProductId(id);
		return ResponseEntity.ok(pic);
	}
}
