package com.Izicap.homework.service;

import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.RequestToGpt;
import org.springframework.stereotype.Service;

public interface ServiceRequest {

    public RequestToGpt requestToRequestToGpt(Request request);
}
