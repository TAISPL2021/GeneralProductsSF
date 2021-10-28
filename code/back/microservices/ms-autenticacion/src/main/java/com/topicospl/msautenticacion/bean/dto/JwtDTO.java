package com.topicospl.msautenticacion.bean.dto;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String nombreUsuario;
    private Collection<? extends GrantedAuthority> authorities;

}
