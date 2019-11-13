package com.spring.elasticsearch.application.repository;

import com.spring.elasticsearch.application.domain.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends ElasticsearchRepository<Car,String> {
}
