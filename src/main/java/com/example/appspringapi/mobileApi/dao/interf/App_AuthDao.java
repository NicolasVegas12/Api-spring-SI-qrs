package com.example.appspringapi.mobileApi.dao.interf;

import com.example.appspringapi.mobileApi.models.App_AuthRequest;
import com.example.appspringapi.mobileApi.models.App_AuthResponse;
import com.example.appspringapi.mobileApi.models.validation.App_ValidationRequest;

public interface App_AuthDao {
    App_AuthResponse login(App_AuthRequest request);
    Boolean validate(App_ValidationRequest request);
}
