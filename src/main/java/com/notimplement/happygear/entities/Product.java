package com.notimplement.happygear.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Table(name = "tbl_product")
@Entity
@Data
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

	@OneToMany(mappedBy = "commentProduct", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<Comment> comments;

	@OneToMany(mappedBy = "pictureProduct", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<ProductPicture> productPictures;
	
	
	@OneToMany(mappedBy = "orderdetailProduct", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<OrderDetail> orderDetails;
}
