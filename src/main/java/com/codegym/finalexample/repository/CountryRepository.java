package com.codegym.finalexample.repository;

import com.codegym.finalexample.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {
}
