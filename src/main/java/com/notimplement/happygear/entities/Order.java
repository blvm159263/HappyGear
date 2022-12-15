package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Table(name = "tbl_order")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, updatable = false)
    private Integer orderId;

    @Column(name = "date")
    private Date date;

    @Column(name = "total")
    private Double total;

    @Column(name = "status")
    private Integer status;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<OrderDetail> orderDetailSet;

    @ManyToOne
    @JoinColumn(name = "user_name")
    @JsonManagedReference
    private User orderUser;
}
