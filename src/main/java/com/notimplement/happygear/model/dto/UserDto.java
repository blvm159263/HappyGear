package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "Username is required")
    private String username;

    @NotNull
    @Size(min = 6, message = "FullName must have at least 6 character")
    private String fullName;

    @NotNull(message = "Address is required")
    private String address;

    @Size(min=6, message = "Password must have at least 6 character")
    @NotNull(message = "Password is required")
    private String password;

    @NotNull(message = "Email is required")
    @Email
    private String email;

    @NotNull(message = "Phone Number is required for personal orders")
    private String phoneNumber;

    @NotNull
    private Boolean status;

    @NotNull
    private Boolean gender;

    @NotNull
    private Integer roleId;

    public UserDto(String username) {
        this.username = username;
    }
}
