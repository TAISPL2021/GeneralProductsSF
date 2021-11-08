package com.topicospl.msautenticacion.service.imp;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.topicospl.msautenticacion.bean.dto.EditUserDTO;
import org.modelmapper.*;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;
import com.topicospl.msautenticacion.exception.RegisterGeneralException;
import com.topicospl.msautenticacion.repository.UserRepository;
import com.topicospl.msautenticacion.service.IUserService;

import javax.persistence.Column;

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

    @Override
    public User editUser(User user, EditUserDTO editUse) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(editUse, user);
		save(user);
        return user;
    }

    @Override
    public void deleteUser(User user) {
         userRepository.delete(user);
    }

}
