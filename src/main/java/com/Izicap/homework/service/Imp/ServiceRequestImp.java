package com.Izicap.homework.service.Imp;

import com.Izicap.homework.config.ChatGptCallPro;
import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.RequestToGpt;
import com.Izicap.homework.service.ServiceRequest;
import org.springframework.stereotype.Service;

@Service
public class ServiceRequestImp implements ServiceRequest {

    public RequestToGpt requestToRequestToGpt(Request request){
        return RequestToGpt.builder().model(ChatGptCallPro.MODEL)
                .prompt(request.getMessage())
                .temperature(ChatGptCallPro.TEMPERATURE)
                .max_Tokens(ChatGptCallPro.MAX_TOKEN)
               // .topP(ChatGptCallPro.TOP_P)
                .build();
    }

}
