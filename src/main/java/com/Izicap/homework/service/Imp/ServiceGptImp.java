package com.Izicap.homework.service.Imp;

import com.Izicap.homework.config.ChatGptCallPro;
import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.RequestToGpt;
import com.Izicap.homework.model.Response;
import com.Izicap.homework.model.ResponseGpt;
import com.Izicap.homework.service.ServiceCSV;
import com.Izicap.homework.service.ServiceGpt;
import com.Izicap.homework.service.ServiceRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Service

@Slf4j
public class ServiceGptImp implements ServiceGpt {
    @Autowired
    private ServiceRequest serviceRequest;
    @Autowired
    private ServiceCSV serviceCSV;


    private static RestTemplate restTemplate = new RestTemplate();
    private String CURL = "https://api.openai.com/v1/completions";
    private String Content_Type="application/json; charset=UTF-8";
    public String API_KEY ="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";
    private String Authorization="Bearer " +API_KEY;
    private String AUTHORIZATION = ChatGptCallPro.API_KEY;
    private String model="text-davinci-003";

    private Double temperature=1.0;



    public ResponseGpt responseGpt(Request request) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type",Content_Type);
        headers.add("Authorization", AUTHORIZATION);
        RequestToGpt requestToGpt=serviceRequest.requestToRequestToGpt(request);
        HttpEntity httpEntity=new HttpEntity<>(requestToGpt,headers);
        ResponseEntity<ResponseGpt> responseGptResponseEntity=restTemplate.postForEntity(
                CURL,
                httpEntity,
                ResponseGpt.class
        );
        Response response = new Response(responseGptResponseEntity.getBody().getChoices().get(0).getText());
        log.info("idkssnksndcknckwnxckwnxcw");
        serviceCSV.addToCsv(request,response);
        return responseGptResponseEntity.getBody();
    }

}
