package com.spring.elasticsearch.application.rest.controller;

import com.spring.elasticsearch.application.domain.Car;
import com.spring.elasticsearch.application.rest.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/car/v1")
@RestController
public class CarRestController {
    @Autowired
    private CarService carService;

    @RequestMapping(path = "/random", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car randomCar(){
        return carService.generateCar();
    }
}
