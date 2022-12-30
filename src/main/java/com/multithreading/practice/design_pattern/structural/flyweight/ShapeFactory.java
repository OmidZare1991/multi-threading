package com.multithreading.practice.design_pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {
    private static Map<String, ShapeAbstract> shapes = new HashMap<>();

    public static ShapeAbstract getShape(String type) {
        ShapeAbstract shape = null;
        if (shapes.get(type) != null) {
            shape = shapes.get(type);
        } else {
            if ("Circle".equals(type)) {
                shape = new CircleWithAbstract();
            } else if ("Rectangle".equals(type)) {
                shape = new RectangleWithAbstract();
            }
            shapes.put(type, shape);
        }
        return shape;
    }
}
