package com.spring.elasticsearch.application.rest.controller;

import com.spring.elasticsearch.application.domain.Car;
import com.spring.elasticsearch.application.repository.CarRepository;
import com.spring.elasticsearch.application.rest.service.CarService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/ES")
@RestController
@Log4j2
public class CarElasticSearchController {
    @Autowired
    private CarRepository carRepository;

    @RequestMapping(path = "/cars/count", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public long countCar() {
        return carRepository.count();
    }

    @RequestMapping(path = "/cars", method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Car createCar(@RequestBody Car car) {
        return carRepository.save(car);
    }

    @RequestMapping(path = "/cars/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Car findByCarId(@PathVariable String id) {
        return carRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/cars/{id}")
    public Car updateCarById(@PathVariable String id, @RequestBody Car updatedCar) {
        updatedCar.setId(id);
        return carRepository.save(updatedCar);
    }
}
