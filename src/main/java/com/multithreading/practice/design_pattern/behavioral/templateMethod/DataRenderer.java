package com.multithreading.practice.design_pattern.behavioral.templateMethod;

public abstract class DataRenderer {
    public void render() {
        String data = readData();
        String processedData = processData(data);
        System.out.println("processedData: " + processedData);
    }

    public abstract String readData();

    public abstract String processData(String data);
}
