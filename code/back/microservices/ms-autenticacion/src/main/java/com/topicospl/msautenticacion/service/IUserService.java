package com.topicospl.msautenticacion.service;

import java.util.List;
import java.util.Optional;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;

public interface IUserService {

	Optional<User> getByUserName(String username);

	Optional<User> getByUserMail(String username);

	boolean existsByUserName(String userName);

	boolean existsByEmail(String email);

	void save(User user);

	List<User> getAll();
	
	void checkRegisterFormat(NewUserDTO userRegForm);

}