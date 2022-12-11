package com.notimplement.happygear.controllers;

import com.notimplement.happygear.model.dto.ProductDto;
import com.notimplement.happygear.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
@RequestMapping("api/products")
public class ProductApi {

	@Autowired
	ProductService service;
	
	@GetMapping("")
	public ResponseEntity<?> listAllProduct(){
		return ResponseEntity.ok(service.listAll());
	}

	@GetMapping("/page")
	public ResponseEntity<?> listProductByPage(@RequestParam("p") Optional<Integer> p){
		Pageable pageable = PageRequest.of(p.orElse(0),9);
		Map<List<ProductDto>, Integer> listIntegerMap = service.listByPage(pageable);
		List<Object> list = new ArrayList<>();
		listIntegerMap.forEach((productDtos, integer) -> {
			list.add(productDtos);
			list.add(integer);
		});
		return ResponseEntity.ok(list);
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
