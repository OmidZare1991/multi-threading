package com.multithreading.practice.design_pattern.structural.adaptor;

public class AdaptorTest {
    public static void main(String[] args) {
        WeatherUI weatherUI = new WeatherUI();
        weatherUI.showTemperature(19406);
    }
}
