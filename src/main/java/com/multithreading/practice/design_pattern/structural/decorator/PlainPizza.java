package com.multithreading.practice.design_pattern.structural.decorator;

public class PlainPizza implements Pizza{
    @Override
    public void bake() {
        System.out.println("baking plain Pizza");
    }
}
