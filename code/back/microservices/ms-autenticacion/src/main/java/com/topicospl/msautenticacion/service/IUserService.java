package com.topicospl.msautenticacion.service;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

public interface IUserService {

	Optional<User> getByUserName(String username);

	Optional<User> getByUserMail(String username);

	boolean existsByUserName(String userName);

	boolean existsByEmail(String email);

	void save(User user);

	List<User> getAll();

}