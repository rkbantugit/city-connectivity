package com.city.connectivity.service;

import com.city.connectivity.model.CityConnectivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityConnectivityService {

    @Autowired
    private CityConnectivity cityConnectivity;

    public boolean isCitiesAreConnected(String source, String destination) {

        return cityConnectivity.isCityConnected(source, destination);

    }
}