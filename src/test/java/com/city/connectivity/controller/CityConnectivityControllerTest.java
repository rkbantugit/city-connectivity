package com.city.connectivity.controller;

import com.city.connectivity.service.CityConnectivityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CityConnectivityControllerTest {

	@Mock
	private CityConnectivityService cityConnectivityService;

	@InjectMocks
	private CityConnectivityController controller;

	@Test
	public void testConnected() throws Exception {
		Mockito.when(cityConnectivityService.isCitiesAreConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(true);

		String isConnected = controller.connectCity("Boston", "NewYark");
		Assert.assertEquals("YES", isConnected);
	}

	@Test
	public void testNotConnected() throws Exception {
		Mockito.when(cityConnectivityService.isCitiesAreConnected(Mockito.anyString(), Mockito.anyString())).thenReturn(false);

		String isConnected = controller.connectCity("Boston", "seattle");
		Assert.assertEquals("NO", isConnected);
	}

}
