package com.multithreading.practice.design_pattern.creational.singleton;

public class DateUtilSingleton {
    private static DateUtilSingleton instance;

    private DateUtilSingleton() {
    }

    public static DateUtilSingleton getInstance() {
        if (instance == null) {                    // this is lazy initialization; whenever getInstance called the instance is initialized
            instance = new DateUtilSingleton();
        }
        return instance;
    }
}
