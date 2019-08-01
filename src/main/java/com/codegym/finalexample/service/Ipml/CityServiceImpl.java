package com.codegym.finalexample.service.Ipml;

import com.codegym.finalexample.model.City;
import com.codegym.finalexample.repository.CityRepository;
import com.codegym.finalexample.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;

public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findOne(id);
    }

    @Override
    public void save(City city) {
        cityRepository.save(city);
    }

    @Override
    public void remove(Long id) {
        cityRepository.delete(id);
    }
}
