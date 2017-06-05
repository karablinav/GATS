package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Tour {

    private List<City> tour = new ArrayList<>();

    // Cache
    private double fitness = 0;
    private double distance = 0;

    public Tour(List<City> tour) {
        this.tour = tour;
    }

    public Tour() {
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }

    public void generateIndividual() {
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
            setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        Collections.shuffle(tour);
    }

    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }


    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // If the tours been altered we need to reset the fitness and distance
        fitness = 0;
        distance = 0;
    }

    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/getDistance();
        }
        return fitness;
    }

    public double getDistance(){
        if (distance == 0) {
            int tourDistance = 0;

            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                City fromCity = getCity(cityIndex);
                City destinationCity;
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }


    public int tourSize() {
        return tour.size();
    }

    public List<City> getTour() {
        return tour;
    }

    public boolean containsCity(City city){
        return tour.contains(city);
    }

    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}
