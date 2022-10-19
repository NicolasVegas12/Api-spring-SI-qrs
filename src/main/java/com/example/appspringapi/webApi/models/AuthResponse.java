package com.example.appspringapi.webApi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AuthResponse {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    private int id;
    @Getter
    @Setter
    @Column(name = "code")
    private String code;

    public AuthResponse(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public AuthResponse() {
    }
}
