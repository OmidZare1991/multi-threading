package com.multithreading.practice.design_pattern.creational.singleton;

import java.io.Serializable;

public class SingletonClonable implements Serializable, Cloneable {

    private SingletonClonable() {
    }

    private static volatile SingletonClonable instance;  // make it volatile

    public static SingletonClonable getInstance() {
        if (instance == null) { // if the instance is null try to get the lock otherwise it is not needed
            synchronized (SingletonClonable.class) {
                if (instance == null) { // acquiring the lock is a very expensive process
                    instance = new SingletonClonable();
                }
            }
        }
        return instance;
    }

    protected Object readResolve() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
