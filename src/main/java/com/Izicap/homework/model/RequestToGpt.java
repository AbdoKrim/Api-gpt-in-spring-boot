package com.Izicap.homework.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

public class RequestToGpt implements Serializable {
    private String model;
    private String prompt;
    private Double temperature;
    @JsonProperty("max_tokens")
    private Integer max_Tokens;
}
