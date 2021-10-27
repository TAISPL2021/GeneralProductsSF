package com.topicospl.msautenticacion.bean.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NewUserDTO {
    @NotBlank
    @JsonProperty("name")
    private String name;
    @JsonProperty("secondName")
    private String secondName;
    @NotBlank
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("secondLastName")
    private String secondLastName;
    @NotBlank
    @JsonProperty("address")
    private String address;
    @NotBlank
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("gender")
    private String gender;
    @NotBlank
    @JsonProperty("userName")
    private String userName;
    @NotBlank
    @JsonProperty("password")
    private String password;

    private String role;
    private String email;
    
}
