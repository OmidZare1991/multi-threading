package com.multithreading.practice.design_pattern.creational.factory.factory;

public class VegaPizza implements Pizza {
    @Override
    public void prepare() {
        System.out.println("preparing vega pizza");
    }

    @Override
    public void bake() {
        System.out.println("baking vega pizza");
    }

    @Override
    public void cut() {
        System.out.println("cutting vega pizza");
    }
}
