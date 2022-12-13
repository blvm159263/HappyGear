package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbl_order_detail")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_id")
    private Integer detailId;

    @Column(name = "price")
    private Double price;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonManagedReference
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product orderdetailProduct;
}
