package com.notimplement.happygear.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Table(name = "tbl_product")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", nullable = false, updatable = false)
	private Integer productId;
	
	@Column(name = "product_name")
	private String productName;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "insurance_info")
	private String insuranceInfo;
	
	@Column(name = "status")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	@JsonBackReference
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonBackReference
	private Category proCategory;
	
	@OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonManagedReference
	private ProductDescription proDesc;
}
