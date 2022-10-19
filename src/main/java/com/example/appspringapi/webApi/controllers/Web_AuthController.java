package com.example.appspringapi.webApi.controllers;

import com.example.appspringapi.webApi.dao.interf.AuthDao;
import com.example.appspringapi.webApi.models.AuthRequest;
import com.example.appspringapi.webApi.models.AuthResponse;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Web_AuthController {
    @Autowired
    AuthDao authDao;

    @RequestMapping(value = "WebApi/Api/login", method = RequestMethod.POST)
    public String loginUser(@RequestBody AuthRequest request){
        AuthResponse response =  authDao.login(request);
        Gson gson = new Gson();

        return gson.toJson(response);
    }


}
