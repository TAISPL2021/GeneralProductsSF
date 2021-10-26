package com.topicospl.msautenticacion.bean.dto;

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
    private String name;
    private String secondName;
    @NotBlank
    private String lastName;
    private String secondLastName;
    @NotBlank
    @JsonProperty("address")
    private String address;
    private String phone;
    @NotBlank
    private String userName;

    @NotBlank
    private String password;
    private String role;


}
