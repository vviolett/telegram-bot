package com.example.demo.repo;

import com.example.demo.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
    City findByCityName(String cityName);
}
