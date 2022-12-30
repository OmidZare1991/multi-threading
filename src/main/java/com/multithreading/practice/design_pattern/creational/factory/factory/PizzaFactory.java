package com.multithreading.practice.design_pattern.creational.factory.factory;

public class PizzaFactory {
    public static Pizza orderPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "vega":
                pizza = new VegaPizza();
                break;
        }
        return pizza;
    }
}
