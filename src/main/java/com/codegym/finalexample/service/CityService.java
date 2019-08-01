package com.codegym.finalexample.service;

import com.codegym.finalexample.model.City;

public interface CityService {
    Iterable<City> findAll();

    City findById(Long id);

    void save(City city);

    void remove(Long id);
}
