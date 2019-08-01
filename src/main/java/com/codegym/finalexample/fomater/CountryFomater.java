package com.codegym.finalexample.fomater;


import com.codegym.finalexample.model.Country;
import com.codegym.finalexample.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class CountryFomater implements Formatter<Country> {

    private CountryService countryService;

    @Autowired
    public CountryFomater (CountryService countryService){
        this.countryService = countryService;
    }
    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.findById(Long.parseLong(text));
    }

    @Override
    public String print(Country object, Locale locale) {
        return object.toString();
    }
}
