package com.spring.elasticsearch.application.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Engine {
    private String fuelType;
    private int horsePower;
    @JsonIgnore
    private String color;
    @JsonIgnore
    private String serialNumber;


    public Engine(String fuleType, int horsePower) {
        this.fuelType = fuleType;
        this.horsePower = horsePower;
    }
}
