package com.multithreading.practice.design_pattern.structural.adaptor;

public class WeatherUI {
    public void showTemperature(int zipCode) {
        WeatherAdaptor weatherAdaptor = new WeatherAdaptor();
        System.out.println(weatherAdaptor.findTemperature(zipCode));
    }
}
