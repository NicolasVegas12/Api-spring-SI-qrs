package com.example.appspringapi.utils;

import javax.crypto.spec.SecretKeySpec;

public interface IEncriptacionService {
    String Encriptar(String encriptar);
    String Desencriptar(String desencriptar);
}
