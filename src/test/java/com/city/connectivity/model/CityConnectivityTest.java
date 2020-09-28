package com.city.connectivity.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectivityTest {

    @InjectMocks
    private CityConnectivity cityConnectivity;

    @Test
    public void connectedCitiesTest() {
        cityConnectivity.addCities("Boston", "New York");
        boolean cityConnected = cityConnectivity.isCityConnected("Boston", "New York");
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void notConnectedTest() {
        cityConnectivity.addCities("Boston", "New York");
        boolean cityConnected = cityConnectivity.isCityConnected("Boston", "Philadelphia");
        Assert.assertFalse(cityConnected);
        cityConnected = cityConnectivity.isCityConnected("Philadelphia", "New York");
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void cityNullTest(){
        cityConnectivity.addCities("Boston", "New York");
        boolean cityConnected = cityConnectivity.isCityConnected(null, "Boston");
        Assert.assertFalse(cityConnected);
        cityConnected = cityConnectivity.isCityConnected("Boston", null);
        Assert.assertFalse(cityConnected);
    }

    @Test
    public void cityNullTest1(){
        cityConnectivity.addCities("Boston", "New York");
        boolean cityConnected = cityConnectivity.isCityConnected(null, null);
        Assert.assertTrue(cityConnected);
    }

    @Test
    public void cityCaseSensitiveTest(){
        cityConnectivity.addCities("Boston", "New York");
        boolean cityConnected = cityConnectivity.isCityConnected("boston", "new york");
        Assert.assertTrue(cityConnected);
        cityConnected = cityConnectivity.isCityConnected("Boston", "new york");
        Assert.assertTrue(cityConnected);
        cityConnected = cityConnectivity.isCityConnected("boston", "NEW York");

    }


    @Test
    public void originAndDestinationCaseSensitiveTest(){
        cityConnectivity.addCities("Boston", "New York");
        boolean cityConnected = cityConnectivity.isCityConnected("NEW YORK", "new york");
        Assert.assertTrue(cityConnected);
    }


}