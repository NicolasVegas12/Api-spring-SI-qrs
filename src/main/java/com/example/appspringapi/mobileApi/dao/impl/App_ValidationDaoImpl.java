package com.example.appspringapi.mobileApi.dao.impl;
import com.example.appspringapi.mobileApi.dao.interf.App_ValidationDao;
import com.example.appspringapi.utils.IEncriptacionService;
import com.example.appspringapi.webApi.models.dto.WP_AuthResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;

public class App_ValidationDaoImpl implements App_ValidationDao {


    @Autowired
    IEncriptacionService encriptacionService;

    @Override
    public Boolean validate(String code) {
        WP_AuthResponse response = new Gson().fromJson(encriptacionService.Desencriptar(code), WP_AuthResponse.class) ;



        return null;
    }
}
