package com.hqins.demo.service.impl;

import com.hqins.demo.dao.CityDao;
import com.hqins.demo.domain.City;
import com.hqins.demo.dto.CityDTO;
import com.hqins.demo.service.CityService;


import com.hqins.demo.vo.CityInfoVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public List<CityInfoVO> findCityByName(String name){
        return cityDao.findByName(name);
    }
    @Override
    public Integer  deleteCityByName(String name){
         return cityDao.deleteByName(name);
    }

    public boolean  insertOneCity(CityDTO city){
       Integer id = cityDao.insertOneCity(city);
       return StringUtils.isNotBlank(id.toString());
    }
}
