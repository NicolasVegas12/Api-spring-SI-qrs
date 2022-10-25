package com.example.appspringapi.mobileApi.models.validation;

import lombok.Getter;
import lombok.Setter;

public class App_ValidationRequest {
    @Getter@Setter
    private Boolean validation;
    @Getter@Setter
    private String code;
}
