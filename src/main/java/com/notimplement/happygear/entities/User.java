package com.notimplement.happygear.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "userId")
    private String userId;
    @Column(name = "userName")
    private String username;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "password")
    private String password;
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "status")
    private boolean status;
    @Column(name = "gender")
    private boolean gender;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    @JsonBackReference
    private Role role;
}
