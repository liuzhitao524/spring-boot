package com.hqins.demo.controller;

import com.alibaba.fastjson.JSON;
import com.hqins.demo.domain.City;
import com.hqins.demo.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value ="/api/city",method= RequestMethod.GET)
    @ResponseBody
    public City findOneCity(@RequestParam(value="cityName") String cityName){
        return cityService.findCityByName(cityName);
    }

    @RequestMapping(value = "api/city/delete",method = RequestMethod.POST)
    @ResponseBody
    public void  deleteCities(@RequestBody String cityName ){
        //just test
         City city = JSON.parseObject(cityName,City.class);
         System.out.println(city.getCityName());
         cityService.deleteCityByName(city.getCityName());
    }

    @RequestMapping(value = "/api/city/insert",method = RequestMethod.POST)
    @ResponseBody
    public void insertCity(@RequestBody City city){
        cityService.insertOneCity(city);
    }


    @RequestMapping(value="/api/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return  cityService.toString();
    }


}
