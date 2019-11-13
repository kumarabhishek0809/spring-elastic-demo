package com.spring.elasticsearch.application.rest.controller;

import com.spring.elasticsearch.application.domain.Car;
import com.spring.elasticsearch.application.rest.service.CarService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1")
@RestController
@Log4j2
public class CarRestController {
    @Autowired
    private CarService carService;

    @RequestMapping(path = "/car", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car randomCar(){
        log.info("Inside Random Car");
        return carService.generateCar();
    }

    @RequestMapping(path = "/cars", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> randomCars(){
        log.info("Inside Random Car");
        return carService.generateCars();
    }

    @RequestMapping(path = "/echo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public String echo(@RequestBody Car car){
        log.info("My Childhood problem");
        log.info(car.toString());
        return car.toString();
    }
}
