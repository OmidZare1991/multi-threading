package com.multithreading.practice.design_pattern.structural.decorator;

public class DecoratorTest {
    public static void main(String[] args) {

        Pizza plainPizza = new PlainPizza();
        plainPizza.bake();

        Pizza pizza = new CheesePizzaDecorator(new PlainPizza()); // both CheesePizzaDecorator and PlainPizza implement Pizza
        pizza.bake();

        Pizza pizza2 = new VeggiePizzaDecorator(new PlainPizza());
        pizza2.bake();

        Pizza pizzaMixed = new VeggiePizzaDecorator(new CheesePizzaDecorator(new PlainPizza()));
        pizzaMixed.bake();
    }
}
