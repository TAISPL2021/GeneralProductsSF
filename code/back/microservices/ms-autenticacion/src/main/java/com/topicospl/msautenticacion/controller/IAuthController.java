package com.topicospl.msautenticacion.controller;


import java.util.List;

import javax.validation.Valid;

import com.topicospl.msautenticacion.bean.dto.EditUserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;
import com.topicospl.msautenticacion.bean.dto.UserDTO;

@RequestMapping("/autenticacion")
public interface IAuthController {

    @PostMapping("/registro")
    ResponseEntity<?> nuevo(@Valid @RequestBody NewUserDTO newUser, BindingResult bindingResult);

    @PostMapping("/login")
    ResponseEntity<?> login(@Valid @RequestBody UserDTO loginuser, BindingResult bindingResult);

    @GetMapping("/users")
    List<User> getAll();
    
    @GetMapping("/users/{uName}")
    ResponseEntity<?> getBy(@PathVariable("uName") String name);

    @PutMapping("/edit")
    ResponseEntity<?> edit(@Valid @RequestBody EditUserDTO editUser, BindingResult bindingResult);

    @DeleteMapping("/eliminar")
    ResponseEntity<?> delete(@Valid @RequestBody UserDTO user , BindingResult bindingResult);

}
