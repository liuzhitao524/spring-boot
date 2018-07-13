package com.hqins.demo.service;

import com.hqins.demo.domain.City;
import com.hqins.demo.dto.CityDTO;
import com.hqins.demo.vo.CityInfoVO;

import java.util.List;

public interface CityService {
    List<CityInfoVO> findCityByName(String cityName);
    Integer  deleteCityByName(String cityName);
    boolean  insertOneCity(CityDTO city);
    Integer     updateCities(CityDTO city);
}
