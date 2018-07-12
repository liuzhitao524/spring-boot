package com.hqins.demo.controller;

import com.hqins.demo.domain.City;
import com.hqins.demo.service.CityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value ="/api/city",method= RequestMethod.GET)
    @ResponseBody
    public City findOneCity(@RequestParam(value="cityName") String cityName){
        return cityService.findCityByName(cityName);
    }
    @RequestMapping(value="/api/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return  cityService.toString();
    }


}
