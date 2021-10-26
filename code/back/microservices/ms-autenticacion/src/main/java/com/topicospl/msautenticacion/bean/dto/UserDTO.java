package com.topicospl.msautenticacion.bean.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;

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
