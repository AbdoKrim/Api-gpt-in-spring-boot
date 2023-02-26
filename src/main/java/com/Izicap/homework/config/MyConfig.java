package com.Izicap.homework.config;

import lombok.Getter;

@Getter
public class MyConfig {
    public static final String CURL = "https://api.openai.com/v1/completions";
    public static final String Content_Type = "application/json; charset=UTF-8";
    public static final String API_KEY = "Bearer " + "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";
    public static final String MODEL = "text-davinci-003";
    public static final Integer MAX_TOKEN = 4000;
    public static final Double TEMPERATURE = 1.0;
}