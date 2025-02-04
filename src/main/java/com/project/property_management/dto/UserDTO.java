package com.project.property_management.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private Long id;
    private String ownerName;
    @NotNull(message = "Owner Email is mandatory")
    @NotEmpty(message = "Owner Email cannot be Empty")
    @Size(min=1, max = 50, message = "Owner Email should be between 1 to 50 characters in length")
    private String ownerEmail;
    @NotNull(message = "Password is mandatory")
    @NotEmpty(message = "Password cannot be Empty")
    private String password;
    private String phoneNumber;
}
