package com.example.appspringapi.webApi.dao.interf;

import com.example.appspringapi.mobileApi.models.App_AuthResponse;
import com.example.appspringapi.webApi.models.AuthRequest;
import com.example.appspringapi.webApi.models.AuthResponse;

public interface AuthDao {
    AuthResponse login(AuthRequest request);
}
