package com.multithreading.practice.design_pattern.creational.factory.abstract_factory;

public class DBDepDao implements Dao{

    @Override
    public void save() {
        System.out.println("saving Department into Database");
    }
}
