package com.multithreading.practice.design_pattern.structural.flyweight;

public class Circle implements Shape {
    private String label;
    private int radius;
    private String fillColor;
    private String lineColor;

    public Circle() {
        this.label = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + label + " with radius " + radius + " and fill color " + fillColor + " and line color " + lineColor);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getFillColor() {
        return fillColor;
    }

    public void setFillColor(String fillColor) {
        this.fillColor = fillColor;
    }

    public String getLineColor() {
        return lineColor;
    }

    public void setLineColor(String lineColor) {
        this.lineColor = lineColor;
    }
}
