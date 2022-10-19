package com.example.appspringapi.mobileApi.controllers;

import com.example.appspringapi.mobileApi.dao.interf.App_AuthDao;
import com.example.appspringapi.mobileApi.models.App_AuthRequest;
import com.example.appspringapi.mobileApi.models.App_AuthResponse;
import com.example.appspringapi.webApi.models.AuthResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class App_AuthController {
    @Autowired
    App_AuthDao authDao;

    @RequestMapping(value = "MobileApi/api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody App_AuthRequest request){
        App_AuthResponse response = authDao.login(request);
        Gson gson = new Gson();

        return gson.toJson(response);
    }
}
