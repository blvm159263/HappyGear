package com.notimplement.happygear.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;
    
    @Column(name = "category_name")
    private String categoryName;
    
    @Column(name = "status")
    private Boolean status;
    
    @OneToMany(mappedBy = "proCategory", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Product> products;
    
    @OneToMany(mappedBy = "desCategory", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<ProductDescription> proDescs;
}
