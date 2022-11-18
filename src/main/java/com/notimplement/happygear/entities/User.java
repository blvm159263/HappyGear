package com.notimplement.happygear.entities;

import javax.persistence.*;

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

    private String username;
    private int age;
    private String address;
    private String password;
    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private boolean status;
    private boolean gender;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
}
