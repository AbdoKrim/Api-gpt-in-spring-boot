package com.Izicap.homework.Controller;

import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.ResponseGpt;

import com.Izicap.homework.service.ServiceGpt;
import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
@RequestMapping("/api/send")
public class GptControllerImp implements GptController  {

    @Autowired
    private ServiceGpt serviceGpt;

    @PostMapping()
    public ResponseGpt sendRequest(Request request) throws IOException {

            return serviceGpt.responseGpt(request);
        }
    }


