package com.spring.elasticsearch.application.repository;

import com.spring.elasticsearch.application.domain.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends ElasticsearchRepository<Car,String> {
    List<Car> findByBrandAndColor(String brand, String color);

    Page<Car> findByBrandAndColor(String brand, String color, PageRequest pageRequest);

    List<Car> findByTypeAndBrand(String type, Optional<String> brand);

    @Query("{ \" range \":{ \" first_release_date \":{\" gt \": ?0 } } }")
    List<Car> findByFirstReleaseDateAfter(long firstReleaseDate);
}
