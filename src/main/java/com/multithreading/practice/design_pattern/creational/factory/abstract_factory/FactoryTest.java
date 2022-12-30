package com.multithreading.practice.design_pattern.creational.factory.abstract_factory;

public class FactoryTest {
    public static void main(String[] args) {
        DaoAbstractFactory factory = DaoFactoryProducer.produceFactory("XML");
        Dao emp = factory.createDao("emp");
        emp.save();
    }
}
