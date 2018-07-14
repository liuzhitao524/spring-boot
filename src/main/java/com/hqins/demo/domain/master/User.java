package com.hqins.demo.domain.master;

import com.hqins.demo.domain.slave.City;

import java.io.Serializable;

public class User implements Serializable {
    private static  final long serialVersionUID = 2018071403L;
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    private String  username;
    private String  description;
    private City city;
}
