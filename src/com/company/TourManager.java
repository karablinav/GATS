package com.company;


import java.util.ArrayList;
import java.util.List;

public class TourManager {
    private  static List<City> destinationCities = new ArrayList<>();

    public static void addCity(City city) {
        destinationCities.add(city);
    }

    public static City getCity(int index){
        return destinationCities.get(index);
    }

    public static int numberOfCities(){
        return  destinationCities.size();
    }
}
