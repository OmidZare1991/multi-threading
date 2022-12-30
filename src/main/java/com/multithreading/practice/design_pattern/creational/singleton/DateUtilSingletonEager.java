package com.multithreading.practice.design_pattern.creational.singleton;

public class DateUtilSingletonEager {
    private static DateUtilSingletonEager instance = new DateUtilSingletonEager(); // eager initialization
    // we use it when we are sure that this class is used at least once in the application
    // another way to create eager initialization is using static blocks

//    static {
//        instance= new DateUtilSingletonEager(); // initialized when the class is loaded into the memory
//    }

    private DateUtilSingletonEager() {
    }

    public static DateUtilSingletonEager getInstance() {
        return instance;
    }
}
