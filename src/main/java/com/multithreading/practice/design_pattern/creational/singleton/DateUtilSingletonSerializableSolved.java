package com.multithreading.practice.design_pattern.creational.singleton;

import java.io.Serializable;

public class DateUtilSingletonSerializableSolved implements Serializable {
    private DateUtilSingletonSerializableSolved() {
    }

    private static volatile DateUtilSingletonSerializableSolved instance;  // make it volatile

    public static DateUtilSingletonSerializableSolved getInstance() {
        if (instance == null) { // if the instance is null try to get the lock otherwise it is not needed
            synchronized (DateUtilSingletonSerializableSolved.class) {
                if (instance == null) { // acquiring the lock is a very expensive process
                    instance = new DateUtilSingletonSerializableSolved();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }
}
