package com.spring.elasticsearch.application.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Car {
    private String brand;
    private String color;
    private String type;
}
