package com.example.appspringapi.webApi.models.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WP_AuthResponse {
    @Getter
    @Setter
    @Id
    @Column(name = "id")
    private Long id;
    @Getter
    @Setter
    @Column(name = "code")
    private String code;

    public WP_AuthResponse(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public WP_AuthResponse() {
        this.id = 0L;
        this.code = "";
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", code='" + code + '\'' +
                '}';
    }
}
