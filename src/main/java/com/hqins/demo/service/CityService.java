package com.hqins.demo.service;

import com.hqins.demo.domain.City;

public interface CityService {
    City findCityByName(String cityName);
    void  deleteCityByName(String cityName);
    void  insertOneCity(City city);
}
