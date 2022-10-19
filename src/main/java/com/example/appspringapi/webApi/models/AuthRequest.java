package com.example.appspringapi.webApi.models;

import lombok.Getter;
import lombok.Setter;

public class AuthRequest {
    @Getter
    @Setter
    private String user;

    @Getter @Setter
    private String password;
}
