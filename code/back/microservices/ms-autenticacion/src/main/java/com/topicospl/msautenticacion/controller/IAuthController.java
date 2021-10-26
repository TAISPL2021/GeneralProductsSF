package com.topicospl.msautenticacion.controller;


import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.JwtDTO;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;
import com.topicospl.msautenticacion.bean.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/auth")
public interface IAuthController {

    @PostMapping("/new")
    ResponseEntity<?> nuevo(@Valid @RequestBody NewUserDTO newUser, BindingResult bindingResult);

    @PostMapping("/login")
    ResponseEntity<JwtDTO> login(@Valid @RequestBody UserDTO loginuser, BindingResult bindingResult);

    @GetMapping("/users")
    List<User> getAll();

}
