package com.example.appspringapi.mobileApi.models;

import lombok.Getter;
import lombok.Setter;

public class App_AuthRequest {
    @Getter
    @Setter
    private String user;

    @Getter @Setter
    private String password;
}
