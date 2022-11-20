package com.notimplement.happygear.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "userId")
    private String userId;
    @Column(name = "username")
    private String username;
    @Column(name = "age")
    private int age;
    @Column(name = "address")
    private String address;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "status")
    private boolean status;
    @Column(name = "gender")
    private boolean gender;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private Role role;
}
