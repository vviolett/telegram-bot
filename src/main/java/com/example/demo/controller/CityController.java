package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<List<City>> findAllCities() {
        List<City> cities = cityService.findAll();
        return new ResponseEntity<>(
                cities,
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City savedCity = cityService.addCity(city);
        return new ResponseEntity<>(
                savedCity,
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    ResponseEntity<City> replaceCity(@RequestBody City newCity, @PathVariable Long id) {
        return cityService.findById(id)
                .map(city -> {
                    city.setCityName(newCity.getCityName());
                    city.setCityDescription(newCity.getCityDescription());
                    return new ResponseEntity<>(
                            cityService.addCity(city),
                            HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(
                        cityService.addCity(newCity),
                        HttpStatus.OK));
    }

    @DeleteMapping(value = "/delete-city/{id}")
    public void deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
    }
}
