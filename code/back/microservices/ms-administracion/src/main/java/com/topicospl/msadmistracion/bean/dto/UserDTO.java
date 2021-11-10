package com.topicospl.msadmistracion.bean.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserDTO {
    @NotBlank
    @JsonProperty("userName")
    private String userName;
    @NotBlank
    @JsonProperty("password")
    private String password;
}
