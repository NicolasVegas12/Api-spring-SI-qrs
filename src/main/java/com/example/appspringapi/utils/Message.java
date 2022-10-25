package com.example.appspringapi.utils;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Data
public class Message {
    @Getter@Setter
    private String title;
    @Getter@Setter
    private String body;
    @Getter@Setter
    private Map<String, String> data;

    public Message(String title, String body, Map<String, String> data) {
        this.title = title;
        this.body = body;
        this.data = data;
    }
}