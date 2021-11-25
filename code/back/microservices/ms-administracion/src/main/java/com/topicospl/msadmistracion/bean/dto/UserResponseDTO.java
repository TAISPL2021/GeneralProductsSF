package com.topicospl.msadmistracion.bean.dto;

import com.topicospl.msadmistracion.bean.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserResponseDTO {

    private int id;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String address;
    private String phone;
    private String gender;
    private String userName;
    private String email;
    private String password;
    private String role;
    
    public UserResponseDTO(User user) {
		this.id = user.getId();
		this.name = user.getName();
		this.secondName = user.getSecondName();
		this.lastName = user.getLastName();
		this.secondLastName = user.getSecondLastName();
		this.address = user.getAddress();
		this.phone = user.getPhone();
		this.gender = user.getGender();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.role = user.getRole().getRoleName().name();
    }

}
