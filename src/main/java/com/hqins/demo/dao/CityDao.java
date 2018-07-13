package com.hqins.demo.dao;


import com.hqins.demo.dto.CityDTO;
import com.hqins.demo.vo.CityInfoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityDao {
    List<CityInfoVO> findByName(@Param("cityName") String cityName);
    Integer  deleteByName(@Param("cityName") String cityName);
    Integer  insertOneCity(CityDTO city);
    Integer     updateCities(CityDTO city);
}
