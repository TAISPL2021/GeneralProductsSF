package com.topicospl.msautenticacion.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;
import com.topicospl.msautenticacion.exception.RegisterGeneralException;
import com.topicospl.msautenticacion.repository.UserRepository;
import com.topicospl.msautenticacion.service.IUserService;

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

	@Override
	public void checkRegisterFormat(NewUserDTO userRegForm) {
		if (userRegForm.getName() == null || userRegForm.getSecondName() == null || userRegForm.getLastName() == null
				|| userRegForm.getSecondLastName() == null || userRegForm.getAddress() == null
				|| userRegForm.getPhone() == null || userRegForm.getGender() == null
				|| userRegForm.getUserName() == null || userRegForm.getEmail() == null
				|| userRegForm.getPassword() == null || userRegForm.getRole() == null)
			throw new RegisterGeneralException("Formato JSON Errado");
	}

}
