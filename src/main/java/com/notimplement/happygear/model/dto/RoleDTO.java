package com.notimplement.happygear.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Integer roleId;

    @Size(min=2, message = "Role name must have more than 2 and less than 50 characters")
    @NotNull(message = "Role name name can not be empty")
    private String roleName;

    private Boolean status;
}
