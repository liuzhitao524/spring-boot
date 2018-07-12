package com.hqins.demo.dao;

import com.hqins.demo.domain.City;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CityDao {
    City findByName(@Param("cityName") String cityName);
    void  deleteByName(@Param("cityName") String cityName);
    void  insertOneCity(City city);
}
