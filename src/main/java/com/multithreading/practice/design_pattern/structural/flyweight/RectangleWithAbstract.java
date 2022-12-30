package com.multithreading.practice.design_pattern.structural.flyweight;

public class RectangleWithAbstract extends ShapeAbstract {
    private String label;

    public RectangleWithAbstract() {
        this.label = "Rectangle";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public void draw(int length, int breadth, String fillStyle) {
        System.out.println("Drawing " + label + " with length " + length + " and breadth " + breadth + " and fillStyle " + fillStyle);
    }

}
