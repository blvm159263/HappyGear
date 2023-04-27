package com.notimplement.happygear.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notimplement.happygear.model.dto.CategoryDto;
import com.notimplement.happygear.service.CategoryService;
import com.notimplement.happygear.util.ResponseUtils;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/categories")
public class CategoryApi {
	@Autowired
	CategoryService service;
	
	@GetMapping("")
	@ApiOperation(value = "List all category", response = CategoryDto.class, responseContainer = "List")
	@ApiResponses(value = {
		@io.swagger.annotations.ApiResponse(
			code = 200, message = "Success", response = CategoryDto.class, responseContainer = "List"
		),
		@io.swagger.annotations.ApiResponse(
			code = 404, message = "Not found"
		),
		@io.swagger.annotations.ApiResponse(
			code = 500, message = "Internal server error"
		)
	})
	public ResponseEntity<?> listAllCategory(){
		try {
			var results = service.listAll();
			if(results.isEmpty()) {
				return new ResponseEntity<>(
					ResponseUtils.error(HttpStatus.NOT_FOUND,"Not found",""),
					HttpStatus.NOT_FOUND
				);
			}
			return new ResponseEntity<>(
				ResponseUtils.success(results, "Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
				ResponseUtils.error(
					HttpStatus.INTERNAL_SERVER_ERROR, 
					"Internal server error",
					e.getMessage()),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Get category by id", response = CategoryDto.class)
	@ApiResponses(value = {
		@io.swagger.annotations.ApiResponse(
			code = 200, message = "Success", response = CategoryDto.class, responseContainer = "Object"
		),
		@io.swagger.annotations.ApiResponse(
			code = 404, message = "Not found"
		),
		@io.swagger.annotations.ApiResponse(
			code = 500, message = "Internal server error"
		)
	})
	public ResponseEntity<?> getCategoryById(@PathVariable(name ="id") Integer id){
		try {
			var results = service.getById(id);
			if(results == null) {
				return new ResponseEntity<>(
					ResponseUtils.error(
						HttpStatus.NOT_FOUND,
						"Catergory Id Not found",
						""
					),
					HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(ResponseUtils.success(results, "Success"), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(
					ResponseUtils.error(
						HttpStatus.INTERNAL_SERVER_ERROR,
						"Internal server error",
						""
					),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto Category){
		return ResponseEntity.ok(service.create(Category));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable(name ="id") Integer id ,@Valid @RequestBody CategoryDto cate){
		cate.setCategoryId(id);
		return ResponseEntity.ok(service.update(cate));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(name ="id") Integer id){
		return ResponseEntity.ok(service.delete(id));
	}
	
	@GetMapping("/customer")
	public ResponseEntity<?> listAllForCus(){
		return ResponseEntity.ok(service.listAllForCus());
	}
}
