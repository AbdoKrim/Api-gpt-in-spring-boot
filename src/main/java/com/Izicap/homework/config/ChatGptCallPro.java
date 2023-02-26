package com.Izicap.homework.config;

import lombok.Getter;

@Getter
public class ChatGptCallPro{
    public static final String CURL = "https://api.openai.com/v1/completions";
    public static final String MEDIA_TYPE = "application/json";
    public static final String API_KEY = "Bearer " + "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";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String MODEL = "text-davinci-003";
    public static final Integer MAX_TOKEN = 4000;
    public static final Double TEMPERATURE = 1.0;
    public static final Double TOP_P = 1.0;

}