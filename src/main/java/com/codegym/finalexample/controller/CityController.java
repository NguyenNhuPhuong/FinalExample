package com.codegym.finalexample.controller;


import com.codegym.finalexample.model.City;
import com.codegym.finalexample.model.Country;
import com.codegym.finalexample.service.CityService;
import com.codegym.finalexample.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("city")
    public ModelAndView list() {
        Iterable<City> cities = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("city/list");
        modelAndView.addObject("cities", cities);
        return modelAndView;
    }

    @GetMapping("city-create")
    public ModelAndView showcreate() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("city-create")
    public ModelAndView save(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "Save successfully");
        return modelAndView;
    }

    @GetMapping("city-edit/{id}")
    public ModelAndView showedit(@PathVariable Long id) {
        City city = cityService.findById(id);
        if (city != null) {
            ModelAndView modelAndView = new ModelAndView("city/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("city-edit")
    public ModelAndView update(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "Update successfully");
        return modelAndView;
    }

    @GetMapping("city-delete/{id}")
    public ModelAndView showdelete(@PathVariable Long id) {
        City city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("city/delete");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

    @PostMapping("city-delete")
    public String delete(@ModelAttribute("city") City city) {
        cityService.remove(city.getId());
        return "redirect:city";
    }

}
