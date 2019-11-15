package com.spring.elasticsearch.application.datasource;

import com.spring.elasticsearch.application.domain.Car;
import com.spring.elasticsearch.application.repository.CarRepository;
import com.spring.elasticsearch.application.rest.service.CarService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
@Log4j2
public class CarElasticDataSource {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarService carService;
    @Autowired
    private RestTemplate restTemplate;

    @EventListener(org.springframework.boot.context.event.ApplicationReadyEvent.class)
    public void populateData() {
        log.info("Start Delete");
        ResponseEntity<String> deleteCars = restTemplate.exchange("http://127.0.0.1:9200/car", HttpMethod.DELETE, null, String.class);
        log.info("End Delete" + deleteCars.getBody());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            cars.add(carService.generateCar());
        }
        carRepository.saveAll(cars);
        log.info("Car Count " + carRepository.count());
    }

}
