package com.topicospl.msautenticacion.controller.imp;

import com.topicospl.msautenticacion.bean.Role;
import com.topicospl.msautenticacion.bean.User;
import com.topicospl.msautenticacion.bean.dto.JwtDTO;
import com.topicospl.msautenticacion.bean.dto.Message;
import com.topicospl.msautenticacion.bean.dto.NewUserDTO;
import com.topicospl.msautenticacion.bean.dto.UserDTO;
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
    PasswordEncoder passwordEncoder;

   @Autowired
    private  AuthenticationManager authenticationManager;

    @Autowired
    IUserService iUserService;
    
    @Autowired
    IRoleService iRoleService;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public ResponseEntity<?> nuevo(@Valid @RequestBody NewUserDTO newUser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos o email inválido"), HttpStatus.BAD_REQUEST);
        if(iUserService.existsByUserName(newUser.getUserName()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);

        User user =
                new User(newUser.getName(), newUser.getSecondName(), newUser.getLastName(),newUser.getSecondLastName(),newUser.getAddress(),newUser.getPhone(),newUser.getUserName(),newUser.getUserName(),
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
        return new ResponseEntity(new Message("user guardado"), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody UserDTO loginuser, BindingResult bindingResult){
        if(bindingResult.hasErrors())
          return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginuser.getUserName(), loginuser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDTO jwtDto = new JwtDTO(jwt, "Bearer",userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

    @Override
    public List<User> getAll() {
        return iUserService.getAll();
    }
}