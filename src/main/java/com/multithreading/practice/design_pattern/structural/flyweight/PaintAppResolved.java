package com.multithreading.practice.design_pattern.structural.flyweight;

public class PaintAppResolved {
    public void render(int numberOfShapes) {
        ShapeAbstract shape = null;
        for (int i = 1; i <= numberOfShapes; i++) {
            if (i % 2 == 0) {
                ShapeAbstract circle = ShapeFactory.getShape("Circle");
                circle.draw(i, "red", "white");
            } else {
                ShapeAbstract rectangle = ShapeFactory.getShape("Rectangle");
                rectangle.draw(i, i + 1, "dotted");
            }
        }
    }
}
