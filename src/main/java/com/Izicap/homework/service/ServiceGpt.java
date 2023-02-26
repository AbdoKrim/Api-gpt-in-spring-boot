package com.Izicap.homework.service;

import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.Response;
import com.Izicap.homework.model.ResponseGpt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public interface ServiceGpt {
    public ResponseGpt responseGpt(Request request) throws IOException;

}
