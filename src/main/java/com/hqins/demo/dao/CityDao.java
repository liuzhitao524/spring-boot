package com.hqins.demo.dao;

import com.hqins.demo.domain.City;

import org.springframework.stereotype.Repository;

@Repository
public interface CityDao {
    City findByName(String cityName);
}
