package com.notimplement.happygear.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "tbl_brand")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "brand_id", nullable = false, updatable = false)
	private Integer brandId;
	
	@Column(name = "brand_name")
	private String brandName;
	
	@Column(name = "status")
	private Boolean status;
	
	@OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
	@JsonBackReference
	private Set<Product> products;
}
