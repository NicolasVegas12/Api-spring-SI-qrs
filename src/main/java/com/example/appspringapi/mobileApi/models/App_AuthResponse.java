package com.example.appspringapi.mobileApi.models;

import com.example.appspringapi.mobileApi.models.login.App_DatosPersonales;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

public class App_AuthResponse {
    @Getter@Setter
    private App_DatosPersonales DatosPersonales;
    @Getter@Setter
    private String JWT;
    @Getter@Setter
    private String Mensaje;
    @Getter@Setter
    private Boolean Ok;


    public App_AuthResponse(App_DatosPersonales datosPersonales, String JWT, String mensaje, Boolean ok) {
        this.DatosPersonales = datosPersonales;
        this.JWT = JWT;
        this.Mensaje = mensaje;
        this.Ok = ok;
    }

    public App_AuthResponse() {
        this.DatosPersonales = new App_DatosPersonales();
        this.JWT = "JWT";
        this.Mensaje = "";
        this.Ok = false;
    }
}
