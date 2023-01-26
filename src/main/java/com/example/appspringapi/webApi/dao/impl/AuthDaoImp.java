package com.example.appspringapi.webApi.dao.impl;

import com.example.appspringapi.repository.IUserAccountRepository;
import com.example.appspringapi.utils.FirebaseMessagingService;
import com.example.appspringapi.utils.IEncriptacionService;
import com.example.appspringapi.utils.Message;
import com.example.appspringapi.webApi.dao.interf.AuthDao;
import com.example.appspringapi.webApi.models.dto.WP_AuthRequest;
import com.example.appspringapi.webApi.models.dto.WP_AuthResponse;
import com.example.appspringapi.repository.IAccesoRepository;
import com.example.appspringapi.webApi.models.entity.UserAccount;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
@Transactional
public class AuthDaoImp implements AuthDao {
    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    IEncriptacionService encriptacionService;

    @Autowired
    FirebaseMessagingService firebaseService;


    @Autowired
    IAccesoRepository accesoRepository;

    @Autowired
    IUserAccountRepository userAccountRepository;

    @Override
    public String login(WP_AuthRequest request) {

        StoredProcedureQuery sp = entityManager.createStoredProcedureQuery("sp_login_wp", WP_AuthResponse.class)
                .registerStoredProcedureParameter("user", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("password", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("tokenAccess", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("dispositivoAccess", String.class, ParameterMode.IN)
                .setParameter("user", request.getUser())
                .setParameter("password", request.getPassword())
                .setParameter("tokenAccess", request.getTokenAccess())
                .setParameter("dispositivoAccess", request.getDispositivoAccess());

        List<WP_AuthResponse> list =sp.getResultList();

        String token = userAccountRepository.findUserAccountByUserAccountAndPassword(request.getUser(),request.getPassword()).getTokenAccess();

        if(list.isEmpty()){
            return "";
        }
        if(token.isEmpty()){
            return "";
        }
        Map<String,String> data = new HashMap<>();
        data.put("NOTIFICATION_CODE","121");
        data.put("DISP_ID",request.getDispositivoAccess());

        try {
            System.out.println(token);
            firebaseService.sendNotification(
                    new Message(
                            "Nueva Solicitud de Acceso",
                            "El dispositivo "+request.getDispositivoAccess()+" ha solicitado Acceso",
                            data
                    ),
                    token
            );
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
        return encriptacionService.Encriptar(list.get(0).toString());
    }




}
