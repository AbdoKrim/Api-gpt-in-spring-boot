package com.Izicap.homework.service;

import com.Izicap.homework.model.Request;
import com.Izicap.homework.model.Response;

import java.io.IOException;

public interface ServiceCSV {
    public void addToCsv(Request request, Response response) throws IOException;
}
