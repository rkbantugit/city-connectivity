package com.city.connectivity.model;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Component
public class CityConnectivity {


    private final List<Set<String>> connectedCities = new LinkedList<>();

    /**
     * Method vlidate the connectivity between the cities
     * @param origin
     * @param destination
     * @return
     */
    public boolean isCityConnected(String origin, String destination) {

        if(StringUtils.isEmpty(origin) && StringUtils.isEmpty(destination)){
            return true;
        }

        if (origin == null || destination == null) {
            return false;
        }

        String originStr = origin.trim().toUpperCase();
        String destinationStr = destination.trim().toUpperCase();

        /**
         * Loop through set of cities and check if any city 'Origin' or 'Destination' is available i  Set, if yes
         *  then add cities to that Set
         */
        for (Set<String> cities : connectedCities) {
            if (cities.contains(originStr) && cities.contains(destinationStr)) {
                return true;
            }
        }

        return false;
    }

    /**
     * This Method is to add the cities
     * @param origin
     * @param destination
     */
    public void addCities(String origin, String destination) {
        boolean isAdded = false;
        List<Set<String>> setCityList = new LinkedList<>();
        String originStr = origin.trim().toUpperCase();
        String destinationStr = destination.trim().toUpperCase();


        // Iterate the connected cities for the list and Add cities to the set
        for (Set<String> cities : connectedCities) {
            if (cities.contains(originStr) || cities.contains(destinationStr)) {
                cities.add(originStr);
                cities.add(destinationStr);
                setCityList.add(cities);
                isAdded = true;
            }
        }
        // validate two different mapping sets in the list
        if (setCityList.size() > 1) {
            Set<String> finalSet = new HashSet<>();
            for (Set<String> cities : setCityList) {
                finalSet.addAll(cities);
                connectedCities.remove(cities);
            }
            connectedCities.add(finalSet);
        }

        if (!isAdded) {
            Set<String> newCities = new HashSet<>();
            newCities.add(originStr);
            newCities.add(destinationStr);
            connectedCities.add(newCities);
        }
    }
}