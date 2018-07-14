package com.hqins.demo.controller;

import com.hqins.demo.common.DemoResult;

import com.hqins.demo.domain.City;
import com.hqins.demo.dto.CityDTO;
import com.hqins.demo.service.CityService;

import com.hqins.demo.vo.CityInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;


@Controller
public class CityController {
    @Autowired
    private CityService cityService;

//    @Resource
////    private DemoResult demoResult;
    @Autowired
    private ApplicationContext applicationContext;

    @Resource
    private RedisTemplate<String,City> redisTemplate;

    @RequestMapping(value="/api/city/{id}",method=RequestMethod.GET)
    @ResponseBody
    public DemoResult findCityById(@PathVariable("id") Integer id){
        DemoResult demoResult = applicationContext.getBean(DemoResult.class);
        String key ="city_"+id;
        ValueOperations<String, City> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if (hasKey) {
            City city = operations.get(key);
            demoResult.setSuccess(true);
            demoResult.setMessage("Success cached");
            demoResult.setContent(city);
            return demoResult;
        }

        // 从 DB 中获取城市信息
        City city = cityService.findCityById(id);
        if(city == null){
            demoResult.setSuccess(false);
            demoResult.setMessage("Not found");
//            demoResult.setContent(null);

            return demoResult;
        }

        // 插入缓存
        operations.set(key, city, 100, TimeUnit.SECONDS);
        demoResult.setSuccess(true);
        demoResult.setMessage("Success");
        demoResult.setContent(city);
        return demoResult;
    }



    @RequestMapping(value ="/api/city",method= RequestMethod.GET)
    @ResponseBody
    public DemoResult findOneCity(@RequestParam(value="cityName") String cityName, HttpServletResponse response){
        DemoResult demoResult = applicationContext.getBean(DemoResult.class);
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
        DemoResult demoResult = applicationContext.getBean(DemoResult.class);
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
        DemoResult demoResult = applicationContext.getBean(DemoResult.class);
        boolean result = cityService.insertOneCity(city);
        demoResult.setContent(result);
        demoResult.setSuccess(result ? true:false );
        return demoResult;
    }

    @RequestMapping(value = "/api/city",method = RequestMethod.PUT)
    @ResponseBody
    public Integer updateCity(@RequestBody CityDTO city){
        return cityService.updateCities(city);
    }

    @RequestMapping(value="/api/test",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return  cityService.toString();
    }


}
