package com.multithreading.practice.design_pattern.creational.factory.factory;

public class PizzaStoreWithFactory {
    public Pizza orderPizza(String type) {
        Pizza pizza = PizzaFactory.orderPizza(type);  // pass the creation process to a factory class
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }
}
