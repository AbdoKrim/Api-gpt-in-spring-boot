package com.Izicap.homework.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Request implements Serializable {
    private String message;
}
