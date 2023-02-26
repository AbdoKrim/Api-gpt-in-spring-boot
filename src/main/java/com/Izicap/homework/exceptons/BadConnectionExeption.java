package com.Izicap.homework.exceptons;

import java.net.UnknownHostException;

public class BadConnectionExeption extends UnknownHostException {
    public BadConnectionExeption(String  message ) {
        super(message);
    }
}
