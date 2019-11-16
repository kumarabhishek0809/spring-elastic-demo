package com.spring.elasticsearch.application.rest.controller;

import com.spring.elasticsearch.application.domain.Car;
import com.spring.elasticsearch.application.repository.CarRepository;
import com.spring.elasticsearch.application.rest.service.CarService;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequestMapping("/v1/ES")
@RestController
@Log4j2
public class CarElasticSearchController {
    @Autowired
    private CarRepository carRepository;

    // /v1/ES/cars/count
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

    @GetMapping(path = "/cars/{brand}/{color}")
    public List<Car> findCarByBrandAndColor(@PathVariable String brand,
                                            @PathVariable String color,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return carRepository.findByBrandAndColor(brand, color,pageRequest).getContent();
    }

    /*
    @GetMapping(path = { "/cars/{type}/{brand}", "/cars/{type}" })
    public List<Car> findCarByBrandAndColorOptional(@PathVariable(name = "type") String type,
                           @PathVariable(name = "brand", required = false) Optional<String> brand) {
        return carRepository.findByTypeAndBrand(type,brand);
    }

*/

    @GetMapping(path = "/cars")
    public List<Car> findCarByBrandAndColorReq(@RequestParam String brand,
                                               @RequestParam String color) {
        return carRepository.findByBrandAndColor(brand, color);
    }

    @GetMapping(path = "/cars/date")
    public List<Car> findCarByFirstReleaseDateAfter(@RequestParam(name = "first_Release_Date") @DateTimeFormat(pattern = "yyyy-MM-dd")
                                                            Date firstReleaseDate) {
        return carRepository.findByFirstReleaseDateAfter(firstReleaseDate.getTime());
    }
}
