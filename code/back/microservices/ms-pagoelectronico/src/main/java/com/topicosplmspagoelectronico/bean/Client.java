package com.topicosplmspagoelectronico.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "client")
@Getter
@Setter
public class Client {

    @Id
    @Column(name = "dni")
    private String dni;
    private String email;
    private String fullName;
    private String country;
}


