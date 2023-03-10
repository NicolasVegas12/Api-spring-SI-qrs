package com.example.appspringapi.mobileApi.models;

import lombok.Getter;
import lombok.Setter;

public class App_AuthRequest {
    @Getter
    @Setter
    private String user;

    @Getter @Setter
    private String password;

    @Getter@Setter
    private String token;

    @Getter@Setter
    private String idDisp;

    @Override
    public String toString() {
        return "App_AuthRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                ", idDisp='" + idDisp + '\'' +
                '}';
    }
}
