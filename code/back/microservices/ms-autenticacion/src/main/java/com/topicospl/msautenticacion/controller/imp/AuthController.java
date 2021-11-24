package com.topicospl.msautenticacion.controller.imp;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.*;
import com.topicospl.msautenticacion.controller.IAuthController;
import com.topicospl.msautenticacion.enums.RoleName;
import com.topicospl.msautenticacion.jwt.JwtProvider;
import com.topicospl.msautenticacion.service.IRoleService;
import com.topicospl.msautenticacion.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
@RestController
public class AuthController implements IAuthController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    private IUserService iUserService;
    
    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUserDTO newUser, BindingResult bindingResult){
        
    	iUserService.checkRegisterFormat(newUser);
    	
    	if(bindingResult.hasErrors())
            return new ResponseEntity<>(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
            
        if(iUserService.existsByUserName(newUser.getUserName())) 
        	 return new ResponseEntity<>(new Message("Nombre Usuario ["+ newUser.getUserName() +"] ya se encuentra registro"), HttpStatus.BAD_REQUEST);
        
        if(iUserService.existsByEmail(newUser.getEmail())) 
        	 return new ResponseEntity<>(new Message("Correo Electronico ["+ newUser.getEmail() +"] ya se encuentra registro"), HttpStatus.BAD_REQUEST);
        
        User user =
                new User(newUser.getName(), newUser.getSecondName(), newUser.getLastName(),newUser.getSecondLastName(),newUser.getAddress(),newUser.getPhone(),newUser.getGender(),newUser.getUserName(),newUser.getEmail(),
                        passwordEncoder.encode(newUser.getPassword()));
        
        if(newUser.getRole().equals("user")){
            Optional<Role> myRole = iRoleService.findByRoleName(RoleName.USER);
            if (myRole.isEmpty()){
                myRole = Optional.ofNullable(Role.builder().roleName(RoleName.valueOf(RoleName.USER.name())).build());
                iRoleService.save(myRole.get());
            }
            user.setRole(myRole.get());
        }
        
        if(newUser.getRole().equals("admin")){
            Optional<Role> myRole = iRoleService.findByRoleName(RoleName.ADMIN);
            if (myRole.isEmpty()){
                 myRole = Optional.ofNullable(Role.builder().roleName(RoleName.valueOf(RoleName.ADMIN.name())).build());
                iRoleService.save(myRole.get());
            }
            user.setRole(myRole.get());
        }

        iUserService.save(user);
        return new ResponseEntity<>(new Message("user guardado"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> login(@Valid @RequestBody UserDTO loginuser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
          return new ResponseEntity<>(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        
        //Si el usuario hace login con correo
        if(loginuser.getUserName().contains("@")) {
        	var tmpUserOptional = iUserService.getByUserMail(loginuser.getUserName());
        	if(tmpUserOptional.isPresent())
        		loginuser.setUserName(tmpUserOptional.get().getUserName());
        }
        
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginuser.getUserName(), loginuser.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, "Bearer",userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }

    @Override
    public List<User> getAll() {
        return iUserService.getAll();
    }

    @Override
    public ResponseEntity<?> edit(EditUserDTO editUser, BindingResult bindingResult) {
        Optional<User> user = iUserService.getByUserMail(editUser.getEmail());
        return (user.isEmpty())?  new ResponseEntity<>( new Message("El usuario no existe con ese correo"), HttpStatus.BAD_REQUEST):  new ResponseEntity<>(iUserService.editUser(user.get(),editUser), HttpStatus.OK);

        //buscar el usuario por el nombre y correo
        // permitir cambio de todo menos de el nombre y correo
        // buscar los que no vengan nulos y cambiarlos
        //guardar

    }

    @Override
    public ResponseEntity<?> delete(UserDTO user, BindingResult bindingResult) {
            	
    	Optional<User> findUser = iUserService.getByUserName(user.getUserName());
    	
    	Optional<User> findUserByEmail = iUserService.getByUserMail(user.getUserName());
    	
        if (findUser.isEmpty() && findUserByEmail.isEmpty()) 
            return new ResponseEntity<>( new Message("El usuario no existe con ese nombre de usuario"), HttpStatus.BAD_REQUEST);
        
        iUserService.deleteUser(findUser.get());
        
        return new ResponseEntity<>(new Message("usuario eliminado"), HttpStatus.OK);
   
    }

	@Override
	public ResponseEntity<?> getBy(String name) {
		
		var tmpUserMail = iUserService.getByUserMail(name);
		System.out.println("MAIL  - " + tmpUserMail.toString());
		if(tmpUserMail.isPresent())
			return new ResponseEntity<>(tmpUserMail.get(),HttpStatus.OK);
		
		var tmpUserName = iUserService.getByUserName(name);
		System.out.println("UserName  - " + tmpUserName.toString());
		if(tmpUserName.isPresent())
			return new ResponseEntity<>(tmpUserName.get(),HttpStatus.OK);
		
		return new ResponseEntity<>("",HttpStatus.CONFLICT);
	}
}