package com.multithreading.practice.design_pattern.structural.flyweight;

public class PaintApp {
    public void render(int numberOfShapes){
        Shape[] shapes = new Shape[numberOfShapes+1];

        for(int i=1;i<=numberOfShapes;i++){
            if(i%2==0){
                shapes[i] = new Circle();
                ((Circle)shapes[i]).setRadius(i);
                ((Circle)shapes[i]).setLineColor("red");
                ((Circle)shapes[i]).setFillColor("white");
                ((Circle)shapes[i]).draw();
            }else {
                shapes[i] = new Rectangle();
                ((Rectangle)shapes[i]).setLength(i);
                ((Rectangle)shapes[i]).setBreadth(i+1);
                ((Rectangle)shapes[i]).setFillStyle("dotted");
                ((Rectangle)shapes[i]).draw();
            }
        }
    }
}
