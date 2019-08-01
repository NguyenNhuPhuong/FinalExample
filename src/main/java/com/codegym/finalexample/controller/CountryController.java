package com.codegym.finalexample.controller;


import com.codegym.finalexample.model.Country;
import com.codegym.finalexample.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public ModelAndView list() {
        Iterable<Country> countries = countryService.findAll();
        ModelAndView modelAndView = new ModelAndView("country/list");
        modelAndView.addObject("countries", countries);
        return modelAndView;
    }

    @GetMapping("country-create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("country/create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("country-create")
    public ModelAndView save(@ModelAttribute("country") Country country) {
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("country/create");
        modelAndView.addObject("message", "save Successfully");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @GetMapping("country-edit/{id}")
    public ModelAndView showedit(@PathVariable Long id) {
        Country country = countryService.findById(id);
        if (country != null) {
            ModelAndView modelAndView = new ModelAndView("country/edit");
            modelAndView.addObject("country", country);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("country-edit")
    public ModelAndView edit(@ModelAttribute("country") Country country) {
        countryService.save(country);
        ModelAndView modelAndView = new ModelAndView("country/edit");
        modelAndView.addObject("message", "Update successfully");
        return modelAndView;
    }

    @GetMapping("country-delete/{id}")
    public ModelAndView Delete(@PathVariable Long id){
        Country country = countryService.findById(id);
        if(country != null){
            ModelAndView modelAndView = new ModelAndView("country/delete");
            modelAndView.addObject("country",country);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        }
    }

    @PostMapping("country-delete")
    public String delete(@ModelAttribute("country") Country country){
        countryService.remove(country.getId());
        return "redirect:country";
    }

}
