package com.multithreading.practice.design_pattern.creational.factory.abstract_factory;

public class DBDaoFactory extends DaoAbstractFactory {
    @Override
    public Dao createDao(String type) {
        Dao dao = null;
        switch (type) {
            case "emp":
                dao = new DBEmpDao();
                break;
            case "dep":
                dao = new DBDepDao();
                break;
        }
        return dao;
    }
}
