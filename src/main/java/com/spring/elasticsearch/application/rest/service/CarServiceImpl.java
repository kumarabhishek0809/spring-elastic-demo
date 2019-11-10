package com.spring.elasticsearch.application.rest.service;

import com.spring.elasticsearch.application.domain.Car;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    private Random random = new Random();

    @Override
    public Car generateCar() {
        String randomBrands = BRANDS.get(random.nextInt(BRANDS.size()));
        String randomColors = COLORS.get(random.nextInt(COLORS.size()));
        String randomTypes = TYPES.get(random.nextInt(TYPES.size()));
        return new Car(randomBrands,randomColors,randomTypes);
    }
}
