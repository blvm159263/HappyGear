package com.notimplement.happygear.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String username;

    private String fullName;

    private String address;

    private String password;

    private String email;

    private String phoneNumber;

    private Boolean status;

    private Boolean gender;

    private Integer roleId;
}
