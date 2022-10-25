package com.example.appspringapi.mobileApi.dao.impl;

import com.example.appspringapi.mobileApi.dao.interf.App_AuthDao;
import com.example.appspringapi.mobileApi.models.App_AuthRequest;
import com.example.appspringapi.mobileApi.models.App_AuthResponse;
import com.example.appspringapi.mobileApi.models.login.App_DatosPersonales;
import com.example.appspringapi.mobileApi.models.validation.App_ValidationRequest;
import com.example.appspringapi.repository.IAccesoRepository;
import com.example.appspringapi.utils.FirebaseMessagingService;
import com.example.appspringapi.utils.IEncriptacionService;
import com.example.appspringapi.utils.Message;
import com.example.appspringapi.webApi.models.dto.WP_AuthRequest;
import com.example.appspringapi.webApi.models.dto.WP_AuthResponse;
import com.example.appspringapi.webApi.models.entity.Acceso;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class App_AuthDaoImpl implements App_AuthDao {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    IEncriptacionService encriptacionService;

    @Autowired
    IAccesoRepository accesoRepository;

    @Autowired
    FirebaseMessagingService firebaseService;

    @Override
    public App_AuthResponse login(App_AuthRequest request) {
        try{
            String query = "sp_login_APP";

            List<App_DatosPersonales> rsp = entityManager.createStoredProcedureQuery(query, App_DatosPersonales.class )
                    .registerStoredProcedureParameter("user",String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("password",String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("token",String.class, ParameterMode.IN)
                    .registerStoredProcedureParameter("idDisp",String.class, ParameterMode.IN)
                    .setParameter("user",request.getUser())
                    .setParameter("password",request.getPassword())
                    .setParameter("token",request.getToken())
                    .setParameter("idDisp",request.getIdDisp())
                    .getResultList();
            if(rsp.isEmpty()){
                return new App_AuthResponse(new App_DatosPersonales(),"","Inicio de Sesion Erroneo",false);
            }{
                return new App_AuthResponse(rsp.get(0),"","",true);
            }
        }catch(Exception e){
            return new App_AuthResponse(new App_DatosPersonales(),"",e.getMessage(),false);
        }

    }

    @Override
    public Boolean validate(App_ValidationRequest request) {
        Gson gson =  new GsonBuilder().create();
        //WP_AuthResponse respuesta =encriptacionService.Desencriptar(request.getCode());


        WP_AuthResponse respuesta = gson.fromJson(encriptacionService.Desencriptar(request.getCode()), WP_AuthResponse.class);
        Acceso acces = accesoRepository.getAccesoByIdAccesoAndCodigo(respuesta.getId(),respuesta.getCode());

        Map<String,String> data = new HashMap<>();
        data.put("ACCEPTATION",request.getValidation().toString());
        data.put("NOTIFICATION_CODE","121");
        try {
            firebaseService.sendNotification(
                    new Message("Respuesta de Aceso","body",data),acces.getTokenAccess()
            );
        } catch (FirebaseMessagingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(acces.toString());
            return true;

    }
}
