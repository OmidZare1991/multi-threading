package com.multithreading.practice.design_pattern.creational.factory.abstract_factory;

public class XMLDaoFactory extends DaoAbstractFactory {
    @Override
    public Dao createDao(String type) {
        Dao dao = null;
        switch (type) {
            case "emp":
                dao = new XmlEmpDao();
                break;
            case "dep":
                dao = new XmlDepDao();
                break;
        }
        return dao;
    }
}
