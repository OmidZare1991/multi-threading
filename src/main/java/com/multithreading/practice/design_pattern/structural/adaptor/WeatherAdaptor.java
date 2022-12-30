package com.multithreading.practice.design_pattern.structural.adaptor;

public class WeatherAdaptor {
    public int findTemperature(int zipCode) {
        String city = null;
        switch (zipCode) {
            case 19406:
                city = "NewYork";
                break;
            case 19405:
                city = "Shiraz";
                break;
        }
        WeatherFinder weatherFinder = new WeatherFinderImpl();
        int temperature = weatherFinder.find(city);
        return temperature;
    }
}
