package com.multithreading.practice.design_pattern.structural.flyweight;

import com.multithreading.practice.App;

public class PaintTest {
    public static void main(String[] args) {
//        PaintApp paintApp = new PaintApp();
//        paintApp.render(10);
        PaintAppResolved paintAppResolved = new PaintAppResolved();
        paintAppResolved.render(10);
    }
}
