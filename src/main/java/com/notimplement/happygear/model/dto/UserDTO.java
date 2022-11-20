package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String username;
    private int age;
    private String address;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean status;
    private boolean gender;
    private int roleId;
}
