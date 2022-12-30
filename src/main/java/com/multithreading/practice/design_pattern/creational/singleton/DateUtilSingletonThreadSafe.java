package com.multithreading.practice.design_pattern.creational.singleton;

public class DateUtilSingletonThreadSafe {
    private DateUtilSingletonThreadSafe() {
    }

    private static DateUtilSingletonThreadSafe instance;

    public static DateUtilSingletonThreadSafe getInstance() {

        synchronized (DateUtilSingletonThreadSafe.class) {
            if (instance == null) {
                instance = new DateUtilSingletonThreadSafe();
            }
        }
        return instance;
    }
}
