package com.multithreading.practice.design_pattern.creational.factory.abstract_factory;

public class DaoFactoryProducer {
    public static DaoAbstractFactory produceFactory(String type) {
        DaoAbstractFactory factory = null;
        switch (type) {
            case "XML":
                factory = new XMLDaoFactory();
                break;
            case "DB":
                factory = new DBDaoFactory();
                break;
        }
        return factory;
    }
}
