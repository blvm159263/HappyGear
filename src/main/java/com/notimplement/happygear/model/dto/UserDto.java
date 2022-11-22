package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userName;
    private String fullName;
    private String address;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean status;
    private boolean gender;
    private long roleId;
}
