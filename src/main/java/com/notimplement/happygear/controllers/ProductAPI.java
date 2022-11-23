package com.notimplement.happygear.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notimplement.happygear.service.ProductService;


@RestController
@RequestMapping("api/product")
public class ProductAPI {

	@Autowired 
	ProductService service;
	
	@GetMapping("/list")
	public ResponseEntity<?> listAll(){
		return ResponseEntity.ok(service.listAll());
	}
	
}
