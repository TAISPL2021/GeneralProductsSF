package com.topicospl.msautenticacion.bean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EditUserDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("secondName")
    private String secondName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("secondLastName")
    private String secondLastName;
    @JsonProperty("address")
    private String address;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("gender")
    private String gender;
    @NotBlank
    @JsonProperty("userName")
    private String userName;
    @JsonProperty("password")
    private String password;
    @NotNull
    @JsonProperty("email")
    private String email;

}
