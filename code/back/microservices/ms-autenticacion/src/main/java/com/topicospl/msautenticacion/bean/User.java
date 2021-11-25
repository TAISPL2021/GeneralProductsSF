package com.topicospl.msautenticacion.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String address;
    private String phone;
    private String gender;
    @Column (unique = true)
    private String userName;
    private String email;
    private String password;
    @OneToOne
    @JoinTable (name = "user_rol", joinColumns = @JoinColumn (name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Role role;

    public User(String name,String secondName, String lastName,String secondLastName,String address, String phone,String gender,String userName, String email, String password) {
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.address = address;
        this.phone = phone;
        this.gender = gender;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
}
