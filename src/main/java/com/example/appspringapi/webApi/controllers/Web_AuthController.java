package com.example.appspringapi.webApi.controllers;

import com.example.appspringapi.utils.FirebaseMessagingService;
import com.example.appspringapi.webApi.dao.interf.AuthDao;
import com.example.appspringapi.utils.Message;
import com.example.appspringapi.webApi.models.dto.WP_AuthRequest;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Web_AuthController {
    @Autowired
    AuthDao authDao;
    @Autowired
    FirebaseMessagingService firebaseService;

    @RequestMapping(value = "WebApi/api/login", method = RequestMethod.POST)
    public ResponseEntity<String> loginUser(@RequestBody WP_AuthRequest request){
        String response =  authDao.login(request);

        if(response.length()>0){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.LOCKED);
        }

    }

    @RequestMapping("WebApi/api/notification")
    @ResponseBody
    public String sendNotification(@RequestBody Message message) throws FirebaseMessagingException {
        return firebaseService.sendNotification(message, "eFNY9aHm5400VofHeqVm05:APA91bFJlkiCgymqBr1_xJb-Z-VIQjdkPNJGNDE994nSduhG5GKWNNnln0bRTxkyumPo4QML-qC6khFH9gx-wb6j8s4jxJm1ubNrvDD0sQAwWdBgghQ1hJSJj-4RMUiNzHhi9udoJl-1");
    }


}
