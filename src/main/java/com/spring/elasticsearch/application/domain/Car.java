package com.spring.elasticsearch.application.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Car implements Serializable {
    public Car(String brand, String color, String type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
    }

    private String brand;
    private String color;
    private String type;
    private boolean available;
    @JsonFormat(pattern = "dd-MMM-yyyy hh:mm:ssaZ", timezone = "Asia/India")
    private Date firstReleaseDate;
    private List<String> additionalFeatures;
    private Engine engine;
    private List<Tyre> tyres;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;

}
