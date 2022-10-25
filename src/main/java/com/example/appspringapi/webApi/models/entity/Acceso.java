package com.example.appspringapi.webApi.models.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ACCESO")
public class Acceso implements Serializable {
    @Id
    @Column(name = "idAcceso")
    @Getter@Setter
    private Long idAcceso;
    @Column(name = "idUser")
    @Getter@Setter
    private int idUser;
    @Column(name = "codigo")
    @Getter@Setter
    private String codigo;
    @Column(name = "fecha")
    @Getter@Setter
    private String fecha;
    @Column(name = "tokenAccess")
    @Getter@Setter
    private String tokenAccess;

    @Override
    public String toString() {
        return "Acceso{" +
                "idAcceso=" + idAcceso +
                ", idUser=" + idUser +
                ", codigo='" + codigo + '\'' +
                ", fecha='" + fecha + '\'' +
                '}';
    }
}
