package com.hqins.demo.service.impl;

import com.hqins.demo.dao.master.UserDao;
import com.hqins.demo.dao.slave.CityDao;
import com.hqins.demo.domain.master.User;
import com.hqins.demo.domain.slave.City;
import com.hqins.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserDao userDao;

    @Autowired
    private CityDao cityDao;
    // just to test : need userid = cityid;
    @Override
    public User findUserById(Integer id){
        User user = userDao.findUserById(id);
        City city = cityDao.findCityById(id);
        user.setCity(city);
        return  user;
    }
}

