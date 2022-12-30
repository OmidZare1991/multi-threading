package com.multithreading.practice.design_pattern.creational.singleton;

public class DateUtilSingletonThreadSafeImproved {
    private DateUtilSingletonThreadSafeImproved() {
    }

    private static volatile DateUtilSingletonThreadSafeImproved instance;  // make it volatile

    public static DateUtilSingletonThreadSafeImproved getInstance() {
        if (instance == null) { // if the instance is null try to get the lock otherwise it is not needed
            synchronized (DateUtilSingletonThreadSafeImproved.class) {
                if (instance == null) { // acquiring the lock is a very expensive process
                    instance = new DateUtilSingletonThreadSafeImproved();
                }
            }
        }
        return instance;
    }
}
