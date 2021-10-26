package com.topicospl.msautenticacion.service.imp;

import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.repository.UserRepository;
import com.topicospl.msautenticacion.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getByUserName (String username){
        return userRepository.findByUserName(username);
    }

    public boolean existsByUserName(String userName){
        return userRepository.existsByUserName(userName);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(User user) {
            userRepository.save(user);
    }
}
