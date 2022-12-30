package com.multithreading.practice.design_pattern.creational.singleton;

import java.io.Serializable;

public class DateUtilSingletonSerializable implements Serializable {
    private DateUtilSingletonSerializable() {
    }

    private static volatile DateUtilSingletonSerializable instance;  // make it volatile

    public static DateUtilSingletonSerializable getInstance() {
        if (instance == null) { // if the instance is null try to get the lock otherwise it is not needed
            synchronized (DateUtilSingletonSerializable.class) {
                if (instance == null) { // acquiring the lock is a very expensive process
                    instance = new DateUtilSingletonSerializable();
                }
            }
        }
        return instance;
    }
}
