package com.notimplement.happygear.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import javax.persistence.*;

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
    @JsonManagedReference
    private Set<Product> products;
    
    @OneToMany(mappedBy = "desCategory", fetch = FetchType.LAZY)
    @JsonManagedReference
    private Set<ProductDescription> proDescs;
}
