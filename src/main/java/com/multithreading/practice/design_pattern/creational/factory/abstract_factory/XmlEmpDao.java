package com.multithreading.practice.design_pattern.creational.factory.abstract_factory;

public class XmlEmpDao implements Dao{
    @Override
    public void save() {
        System.out.println("saving Employee into XML");
    }
}
