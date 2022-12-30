package com.multithreading.practice.design_pattern.structural.flyweight;

public class CircleWithAbstract extends ShapeAbstract {
    private String label;

    public CircleWithAbstract() {
        this.label = "Circle";
    }
    public String getLabel() {
        return label;
    }
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void draw(int radius, String fillColor, String lineColor) {
        System.out.println("Drawing " + label + " with radius " + radius + " and fill color " + fillColor + " and line color " + lineColor);
    }

}
