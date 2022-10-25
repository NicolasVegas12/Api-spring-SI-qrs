package com.example.appspringapi.mobileApi.controllers;

import com.example.appspringapi.mobileApi.dao.interf.App_AuthDao;
import com.example.appspringapi.mobileApi.models.App_AuthRequest;
import com.example.appspringapi.mobileApi.models.App_AuthResponse;
import com.example.appspringapi.mobileApi.models.validation.App_ValidationRequest;
import com.example.appspringapi.utils.FirebaseMessagingService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class App_AuthController {
    @Autowired
    App_AuthDao authDao;



    @RequestMapping(value = "MobileApi/api/sp_login_app", method = RequestMethod.POST)
    public String loginUser(@RequestBody App_AuthRequest request){

        App_AuthResponse response = authDao.login(request);
        Gson gson = new Gson();
        return gson.toJson(response);
    }
    @RequestMapping(value = "MobileApi/api/sp_auth_app", method = RequestMethod.POST)
    public Boolean loginUser(@RequestBody App_ValidationRequest request){
        Boolean response = authDao.validate(request);
        if(response){

        }else{

        }

        return response;
    }
}
