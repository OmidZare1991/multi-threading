package com.multithreading.practice.design_pattern.structural.decorator;

public class VeggiePizzaDecorator extends PizzaDecorator{
    public VeggiePizzaDecorator(Pizza pizza) {
        super(pizza);
    }
    public void bake(){
        super.bake();
        System.out.println("adding Vegie toppings ...");
    }
}
