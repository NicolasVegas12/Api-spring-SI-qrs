package com.example.appspringapi.mobileApi.dao.impl;

import com.example.appspringapi.mobileApi.dao.interf.App_AuthDao;
import com.example.appspringapi.mobileApi.models.App_AuthRequest;
import com.example.appspringapi.mobileApi.models.App_AuthResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class App_AuthDaoImpl implements App_AuthDao {
    @Override
    public App_AuthResponse login(App_AuthRequest request) {
        return new App_AuthResponse(0,"");
    }
}
