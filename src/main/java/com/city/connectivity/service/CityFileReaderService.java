package com.city.connectivity.service;

import com.city.connectivity.model.CityConnectivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class CityFileReaderService {

    @Autowired
    private CityConnectivity cityConnect;

    @Value("classpath:city/city.txt")
    private Resource cityInfoFile;


    @PostConstruct
    public void dataLoad() throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(cityInfoFile.getInputStream()))){
            reader.lines().forEach(line -> {
                try {
                    addCities(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    private void addCities(String line) throws IOException {
        String [] str = line.trim().split(",");
        if(str.length != 2){
            throw new IOException("City connectivity mapping issue. Input Data :: " + line);
        }
        cityConnect.addCities(str[0].trim(), str[1].trim());
    }


}
