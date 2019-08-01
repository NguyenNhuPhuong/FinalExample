package com.codegym.finalexample.repository;

import com.codegym.finalexample.model.City;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CityRepository extends PagingAndSortingRepository<City, Long> {

}
