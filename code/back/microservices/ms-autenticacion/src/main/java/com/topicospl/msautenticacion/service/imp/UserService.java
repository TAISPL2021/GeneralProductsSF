package com.topicospl.msautenticacion.service.imp;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.Message;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;
import com.topicospl.msautenticacion.repository.UserRepository;
import com.topicospl.msautenticacion.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getByUserName(String username) {
		return userRepository.findByUserName(username);
	}


	public boolean existsByUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}


	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> getAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getByUserMail(String username) {
		return userRepository.findByEmail(username);
	}

}
