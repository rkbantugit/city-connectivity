package com.city.connectivity.service;

import com.city.connectivity.model.CityConnectivity;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RunWith(MockitoJUnitRunner.class)
public class CityFileReaderServiceTest {

    @Mock
    private CityConnectivity cityConnectivity;

    @Mock
    private Resource cityInfoResource;

    @InjectMocks
    CityFileReaderService fileReaderService;

    @Test
    public void happyPath() throws IOException {
        InputStream is = new ByteArrayInputStream("Boston, New York".getBytes());
        Mockito.when(cityInfoResource.getInputStream()).thenReturn(is);
        fileReaderService.dataLoad();
    }

    @Test(expected = IOException.class)
    public void ioExceptionTest() throws IOException {
        Mockito.when(cityInfoResource.getInputStream()).thenThrow(IOException.class);
        fileReaderService.dataLoad();
    }


}
