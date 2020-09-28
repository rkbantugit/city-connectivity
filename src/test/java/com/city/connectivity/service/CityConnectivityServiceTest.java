package com.city.connectivity.service;

import com.city.connectivity.model.CityConnectivity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectivityServiceTest {

    @Mock
    private CityConnectivity cityConnectivity;

    @InjectMocks
    private CityConnectivityService cityConnectivityService;

    @Test
    public void testPath() {
        Mockito.when(cityConnectivity.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

        boolean isConnected = cityConnectivityService.isCitiesAreConnected("Boston", "New York");
        Assert.assertTrue(isConnected);
    }

    @Test
    public void testNotConnected(){
        Mockito.when(cityConnectivity.isCityConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

        boolean isConnected = cityConnectivityService.isCitiesAreConnected("Boston", "New York");
        Assert.assertFalse(isConnected);
    }
}
