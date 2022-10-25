package com.example.appspringapi.webApi.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ACCOUNT")
public class UserAccount {
    @Id
    @Getter@Setter
    private Long idUser;
    @Getter@Setter
    private String userAccount;
    @Getter@Setter
    private String password;
    @Getter@Setter
    private int rol;
    @Getter@Setter
    private String fechaRegistro;
    @Getter@Setter
    private String tokenAccess;
    @Getter@Setter
    private String dispositivo;
}
