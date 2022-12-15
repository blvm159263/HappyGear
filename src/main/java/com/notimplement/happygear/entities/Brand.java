package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

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
