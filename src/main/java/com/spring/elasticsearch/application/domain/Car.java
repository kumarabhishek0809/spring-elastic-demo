package com.spring.elasticsearch.application.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Document(indexName = "car")
public class Car implements Serializable {

    @Id
    private String id;

    public Car(String brand, String color, String type) {
        this.brand = brand;
        this.color = color;
        this.type = type;
    }

    private String brand;
    private String color;
    private String type;
    private boolean available;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "Asia/India")
    @Field(type = FieldType.Date, format = DateFormat.date_time)
    private Date firstReleaseDate;
    private List<String> additionalFeatures;
    private Engine engine;
    private List<Tyre> tyres;
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;

}
