package com.topicospl.msautenticacion.service;

import com.topicospl.msautenticacion.bean.User;

import java.util.Optional;

public interface IUserService {

    Optional<User> getByUserName(String username);

    boolean existsByUserName(String userName);

    boolean existsByEmail(String email);

    void save(User user);
}