package com.Izicap.homework.Controller;

import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.Response;
import com.Izicap.homework.model.ResponseGpt;

import java.io.IOException;


public interface GptController {

    public ResponseGpt sendRequest(Request request) throws IOException;
}
