package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_product_picture")
public class ProductPicture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "picture_id")
    private Integer pictureId;
    
    @Column(name = "picture_url")
    private String pictureUrl;
    
    @Column(name = "status")
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonBackReference
    private Product pictureProduct;
}
