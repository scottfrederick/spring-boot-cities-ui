package com.example.cities.repository;

import com.example.cities.model.City;
import feign.RequestLine;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository {
    @RequestLine("GET /cities")
    public PagedResources<City> findAll();
}
