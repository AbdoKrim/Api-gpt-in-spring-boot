package com.Izicap.homework.service.Imp;

import com.Izicap.homework.config.MyConfig;
import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.RequestToGpt;
import com.Izicap.homework.service.ServiceRequest;
import org.springframework.stereotype.Service;

@Service
public class ServiceRequestImp implements ServiceRequest {

    public RequestToGpt requestToRequestToGpt(Request request){
        return RequestToGpt.builder().model(MyConfig.MODEL)
                .prompt(request.getMessage())
                .temperature(MyConfig.TEMPERATURE)
                .max_Tokens(MyConfig.MAX_TOKEN)
                .build();
    }

}
