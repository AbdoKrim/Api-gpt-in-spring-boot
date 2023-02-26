package com.Izicap.homework.service.Imp;

import com.Izicap.homework.config.MyConfig;
import com.Izicap.homework.exceptons.BadConnectionExeption;
import com.Izicap.homework.model.*;
import com.Izicap.homework.service.ServiceCSV;
import com.Izicap.homework.service.ServiceGpt;
import com.Izicap.homework.service.ServiceRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

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
    private String AUTHORIZATION = MyConfig.API_KEY;
    private String model="text-davinci-003";

    private Double temperature=1.0;



    public ResponseGpt responseGpt(Request request) throws IOException, BadConnectionExeption {
        HttpHeaders headers = new HttpHeaders();
        ResponseGpt responseGpt = new ResponseGpt();
        headers.add("Content-Type",Content_Type);
        headers.add("Authorization", AUTHORIZATION);
        RequestToGpt requestToGpt=serviceRequest.requestToRequestToGpt(request);

        try {
            String  address = InetAddress.getByName("www.google.com").getHostAddress();
            InetAddress inet = InetAddress.getByName(address);
            log.info("Sending Ping Request to " + address);
            if(inet.isReachable(50000)){
                HttpEntity httpEntity=new HttpEntity<>(requestToGpt,headers);
                ResponseEntity<ResponseGpt> responseGptResponseEntity=restTemplate.postForEntity(
                        CURL,
                        httpEntity,
                        ResponseGpt.class
                );

                Response response = new Response(responseGptResponseEntity.getBody().getChoices().get(0).getText());
                serviceCSV.addToCsv(request,response);
                return responseGptResponseEntity.getBody();
            }
            else{
                log.info("Host is not reachable");
                throw new BadConnectionExeption("bad connection to server !!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            List<Choice> choiceList=new ArrayList<Choice>();
            Choice  choice = new Choice();
            choice.setText("bad connection to server !!");
            choice.setIndex(888);
            choiceList.add(choice);
            responseGpt.setChoices(choiceList);
            return responseGpt;
        }

    }

}
