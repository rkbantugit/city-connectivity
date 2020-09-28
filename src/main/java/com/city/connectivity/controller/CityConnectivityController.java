package com.city.connectivity.controller;

import com.city.connectivity.service.CityConnectivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CityConnectivityController {

    @Autowired
    private CityConnectivityService cityConnectivityService;

    @GetMapping(path = "/cityconnectivity", produces = MediaType.APPLICATION_JSON_VALUE)
    public String connectCity(@RequestParam("origin") String origin,
                               @RequestParam("destination") String destination) throws Exception {
        // Service call to validate the Connectivity between the cities
        return cityConnectivityService.isCitiesAreConnected(origin, destination) ? "YES":"NO";

    }
}
