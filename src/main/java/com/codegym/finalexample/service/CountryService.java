package com.codegym.finalexample.service;

import com.codegym.finalexample.model.Country;

public interface CountryService {
    Iterable<Country> findAll();

    Country findById(Long id);

    void save(Country country);

    void remove(Long id);
}
