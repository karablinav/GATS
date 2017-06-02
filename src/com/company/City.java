package com.company;

public class City {

    private int x;
    private int y;

    public City() {
        this.x = (int)(Math.random()*200);
        this.y = (int)(Math.random()*200);
    }

    public City(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double distanceTo(City city){
        int xDistance = Math.abs(getX() - city.getX());
        int yDistance = Math.abs(getY() - city.getY());
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );

        return distance;
    }

    @Override
    public String toString() {
        return "{" + x +", " +y+ '}';
    }
}
