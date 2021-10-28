package com.topicospl.msautenticacion.service.imp;

import com.topicospl.msautenticacion.bean.PrincipalUser;
import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

    @Autowired
    private IUserService iUserService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = iUserService.getByUserName(userName).get();
        return PrincipalUser.build(user);
    }

}
