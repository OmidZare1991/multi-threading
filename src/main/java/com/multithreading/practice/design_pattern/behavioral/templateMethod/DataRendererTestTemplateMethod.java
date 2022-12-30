package com.multithreading.practice.design_pattern.behavioral.templateMethod;

public class DataRendererTestTemplateMethod {
    public static void main(String[] args) {
        DataRenderer dataRenderer = new XMLDataRenderer();
        dataRenderer.render();
    }
}
