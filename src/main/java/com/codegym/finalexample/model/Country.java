package com.codegym.finalexample.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Component
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @OneToMany(targetEntity = City.class)
    List<City> cities;

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
