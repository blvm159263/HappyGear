package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
	
	@Column(name ="quantity")
	private Integer quantity;
	
	@Column(name = "insurance_info")
	private String insuranceInfo;

	@Column(name = "picture")
	private String picture;
	
	@Column(name = "status")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "brand_id")
	@JsonManagedReference
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	@JsonManagedReference
	private Category proCategory;
	
	@OneToOne(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonBackReference
	private ProductDescription proDesc;

	@OneToMany(mappedBy = "commentProduct", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Comment> comments;

	@OneToMany(mappedBy = "pictureProduct", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<ProductPicture> productPictures;
	
	
	@OneToMany(mappedBy = "orderdetailProduct", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<OrderDetail> orderDetails;
}
