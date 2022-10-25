package com.example.appspringapi.webApi.dao.interf;

import com.example.appspringapi.webApi.models.dto.WP_AuthRequest;

public interface AuthDao {
    String login(WP_AuthRequest request);
}
