package com.example.appspringapi.webApi.dao.impl;

import com.example.appspringapi.webApi.dao.interf.AuthDao;
import com.example.appspringapi.webApi.models.AuthRequest;
import com.example.appspringapi.webApi.models.AuthResponse;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class AuthDaoImp implements AuthDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public AuthResponse login(AuthRequest request) {
        String query = "sp_login_WP";
        List<AuthResponse> rsp = entityManager.createStoredProcedureQuery(query, AuthResponse.class )
                .registerStoredProcedureParameter("user",String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("password",String.class, ParameterMode.IN)
                .setParameter("user",request.getUser())
                .setParameter("password",request.getPassword())
                .getResultList();
        if(rsp.isEmpty()){
            return new AuthResponse(0,"");
        }else{
            return rsp.get(0);
        }


    }
}
