package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @NotBlank(message = "Username cannot blank")
    private String username;
    @NotBlank(message = "Password cannot blank")
    private String password;
}
