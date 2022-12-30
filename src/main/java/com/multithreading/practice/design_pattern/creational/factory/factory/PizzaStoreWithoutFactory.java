package com.multithreading.practice.design_pattern.creational.factory.factory;

public class PizzaStoreWithoutFactory {
    public Pizza orderPizza(String type) {
        Pizza pizza = null;
        switch (type) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "vega":
                pizza = new VegaPizza();
                break;
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        return pizza;
    }
}
