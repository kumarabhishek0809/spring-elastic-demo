package com.spring.elasticsearch.application.rest.service;

import com.spring.elasticsearch.application.domain.Car;
import com.spring.elasticsearch.application.domain.Engine;
import com.spring.elasticsearch.application.domain.Tyre;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {

    private Random random = new Random();

    @Override
    public Car generateCar() {
        Car car = createCar();
        return car;
    }

    @Override
    public List<Car> generateCars() {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < random.nextInt(10); i++) {
            Car car = createCar();
            cars.add(car);
        }
        return cars;
    }

    private Car createCar() {
        String randomBrands = BRANDS.get(random.nextInt(BRANDS.size()));
        String randomColors = COLORS.get(random.nextInt(COLORS.size()));
        String randomTypes = TYPES.get(random.nextInt(TYPES.size()));
        Car car = new Car(randomBrands, randomColors, randomTypes);
        car.setAvailable(random.nextBoolean());
        car.setFirstReleaseDate(new Date());
        List<String> additionalFatures = new ArrayList<>();
        ADDITIONAL_FEATURES.forEach(af -> additionalFatures.add(af));
        car.setAdditionalFeatures(additionalFatures);
        String fuleType = FUEL_TYPES.get(random.nextInt(FUEL_TYPES.size()));
        int horsePower = 100 + random.nextInt(121);
        Engine engine = new Engine(fuleType, horsePower);
        car.setEngine(engine);

        List<Tyre> tyres = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            String tyreManufacture = TYRE_MANUFACTURES.get(random.nextInt(TYRE_MANUFACTURES.size()));
            int tyreSize = 15+random.nextInt(3);
            int tyrePrice = 200 + random.nextInt(random.nextInt(201));

            Tyre tyre = new Tyre(tyreManufacture, tyreSize, tyrePrice);
            tyres.add(tyre);
        }
        car.setTyres(tyres);
        car.setSecretFeature(random.nextBoolean() ? "Can Fly" : null);
        return car;
    }
}
