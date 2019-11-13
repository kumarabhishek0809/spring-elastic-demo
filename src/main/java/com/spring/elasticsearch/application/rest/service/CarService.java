package com.spring.elasticsearch.application.rest.service;

import com.spring.elasticsearch.application.domain.Car;

import java.util.List;

import static java.util.List.of;

public interface CarService {
    List<String> BRANDS = of("Toyota", "Honda", "Ford","Tesla", "Maruti","Ashoka");
    List<String> COLORS = of("Red", "Black", "White", "Green","Blue","Yellow");
    List<String> TYPES = of("Sedan", "SUV", "MPV");
    List<String> ADDITIONAL_FEATURES = of("GPS", "ALARM", "SUN ROOF", "Media Player", "LEATHER SEATS");
    List<String> FUEL_TYPES = of("Petrol","Electic","Hybrid");
    List<String> TYRE_MANUFACTURES = of("Good Year","Bridestone","Dunlop");

    Car generateCar();
    List<Car> generateCars();
}
