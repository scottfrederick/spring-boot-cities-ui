package com.example.cities.repository;

import com.example.cities.model.City;
import feign.RequestLine;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Repository;

import javax.inject.Named;

@Repository
public interface CityRepository {
    @RequestLine("GET /cities?page={page}&size={size}")
    public PagedResources<City> findAll(@Named("page") String page, @Named("size") String size);
}
