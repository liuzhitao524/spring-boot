package com.hqins.demo.controller;

import com.alibaba.fastjson.JSON;
import com.hqins.demo.common.DemoResult;
import com.hqins.demo.domain.City;
import com.hqins.demo.dto.CityDTO;
import com.hqins.demo.service.CityService;

import com.hqins.demo.vo.CityInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;
    @Resource
    DemoResult demoResult;
    @RequestMapping(value ="/api/city",method= RequestMethod.GET)
    @ResponseBody
    public DemoResult findOneCity(@RequestParam(value="cityName") String cityName, HttpServletResponse response){
        List<CityInfoVO> cityInfoVO = cityService.findCityByName(cityName);
        if(cityInfoVO == null || cityInfoVO.isEmpty()){
            response.setStatus(404);
        }
        demoResult.setContent(cityInfoVO);
        return demoResult;
    }

    @RequestMapping(value = "api/city",method = RequestMethod.DELETE)
    @ResponseBody
    public DemoResult  deleteCities(@RequestParam String cityName ){
        //just test
         System.out.println(cityName);
         Integer count = cityService.deleteCityByName(cityName);
        demoResult.setContent(count);
        demoResult.setSuccess(count.intValue() >0 ? true:false );
        return demoResult;
    }

    @RequestMapping(value = "/api/city",method = RequestMethod.POST)
    @ResponseBody
    public DemoResult insertCity(@RequestBody CityDTO city){
        boolean result = cityService.insertOneCity(city);
        //demoResult.setContent(result);
        demoResult.setSuccess(result ? true:false );
        return demoResult;
    }


    @RequestMapping(value="/api/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return  cityService.toString();
    }


}
