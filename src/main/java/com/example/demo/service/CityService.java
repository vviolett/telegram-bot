package com.example.demo.service;

import com.example.demo.domain.City;
import com.example.demo.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {
    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public void deleteCity(Long id){
        cityRepository.deleteById(id);
    }

    public City addCity(City city){
        return cityRepository.save(city);
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public Optional<City> findById(Long id){
        return cityRepository.findById(id);
    }

    public City findByCityName(String cityName){
        return cityRepository.findByCityName(cityName);
    }
}
