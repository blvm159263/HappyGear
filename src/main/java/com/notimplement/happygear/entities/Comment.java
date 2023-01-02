package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_comment")
public class Comment {
    @Id
    @Column(name = "comment_id")
    private String commentId;
    
    @Column(name = "content")
    private String content;

    @Column(name = "comment_parent_id")
    private String commentParentId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonManagedReference
    private Product commentProduct;

    @ManyToOne
    @JoinColumn(name = "user_name")
    @JsonManagedReference
    private User commentUser;
}
