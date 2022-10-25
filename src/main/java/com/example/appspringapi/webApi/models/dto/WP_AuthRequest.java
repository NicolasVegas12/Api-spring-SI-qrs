package com.example.appspringapi.webApi.models.dto;

import lombok.Getter;
import lombok.Setter;

public class WP_AuthRequest {
    @Getter
    @Setter
    private String user;

    @Getter @Setter
    private String password;

    @Getter@Setter
    private String tokenAccess;
    @Getter@Setter
    private String dispositivoAccess;

    @Override
    public String toString() {
        return "WP_AuthRequest{" +
                "user='" + user + '\'' +
                ", password='" + password + '\'' +
                ", tokenAccess='" + tokenAccess + '\'' +
                ", dispositivoAccess='" + dispositivoAccess + '\'' +
                '}';
    }
}
