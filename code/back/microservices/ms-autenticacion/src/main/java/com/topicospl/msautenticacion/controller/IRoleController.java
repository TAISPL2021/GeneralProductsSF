package com.topicospl.msautenticacion.controller;

import com.topicospl.msautenticacion.bean.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/role")
public interface IRoleController {

    @GetMapping("/roles")
    List<Role> getRoles ();

    @PostMapping("/new")
    Role createRole(@PathVariable String role);
}
