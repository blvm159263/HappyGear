package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @JsonBackReference
    private Set<Product> products;
    
    @OneToMany(mappedBy = "desCategory", fetch = FetchType.LAZY)
    @JsonBackReference
    private Set<ProductDescription> proDescs;
}
