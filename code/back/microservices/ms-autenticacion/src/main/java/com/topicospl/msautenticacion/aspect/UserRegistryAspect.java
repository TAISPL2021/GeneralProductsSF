package com.topicospl.msautenticacion.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.topicospl.msautenticacion.bean.User;

@Aspect
@Component
public class UserRegistryAspect {

    @Autowired
    private PasswordEncoder passwordEncoder;
	
    @Around(value = "execution(* com.topicospl.msautenticacion.service.imp.UserService.save(..)) and args(newUser)" )
	public void cipherAspect(ProceedingJoinPoint proceedingJoinPoint, User newUser) throws Throwable {
		var passCipher = passwordEncoder.encode(newUser.getPassword());
		newUser.setPassword(passCipher);
		
		proceedingJoinPoint.proceed();
	
	}
}
