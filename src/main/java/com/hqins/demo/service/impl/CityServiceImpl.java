package com.hqins.demo.service.impl;

import com.hqins.demo.dao.CityDao;
import com.hqins.demo.domain.City;
import com.hqins.demo.service.CityService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public City findCityByName(String name){
        return cityDao.findByName(name);
    }

}
