package com.spring.elasticsearch.application.rest.service;

import com.spring.elasticsearch.application.domain.Car;

import java.util.List;

import static java.util.List.of;

public interface CarService {
    List<String> BRANDS = of("Toyota","Honda","Ford");
    List<String> COLORS = of("Red","Black","White");
    List<String> TYPES = of("Sedan","SUV","MPV");

    Car generateCar();
}
