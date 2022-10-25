package com.example.appspringapi.mobileApi.models.login;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class App_DatosPersonales {
    @Getter
    @Setter
    @Id
    @Column(name = "idUser")
    private int idUser;
    @Getter
    @Setter
    @Column(name="nombres")
    private String nombres;
    @Getter
    @Setter
    @Column(name="apellidos")
    private String apellidos;
    @Getter
    @Setter
    @Column(name="email")
    private String email;
    @Getter
    @Setter
    @Column(name="telefono")
    private String telefono;
    @Getter
    @Setter
    @Column(name="direccion")
    private String direccion;
    @Getter
    @Setter
    @Column(name="dni")
    private String dni;

    public App_DatosPersonales(int idUser, String nombres, String apellidos, String email, String telefono, String direccion, String dni) {
        this.idUser = idUser;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.dni = dni;
    }

    public App_DatosPersonales() {
        this.idUser = 0;
        this.nombres = "";
        this.apellidos = "";
        this.email = "";
        this.telefono = "";
        this.direccion = "";
        this.dni = "";
    }
}