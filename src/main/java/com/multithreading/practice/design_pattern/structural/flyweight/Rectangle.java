package com.multithreading.practice.design_pattern.structural.flyweight;

public class Rectangle implements Shape {
    private String label;
    private int length;
    private int breadth;
    private String fillStyle;

    public Rectangle() {
        this.label = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Drawing " + label + " with length " + length + " and breadth " + breadth + " and fillStyle " + fillStyle);
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public String getFillStyle() {
        return fillStyle;
    }

    public void setFillStyle(String fillStyle) {
        this.fillStyle = fillStyle;
    }
}
