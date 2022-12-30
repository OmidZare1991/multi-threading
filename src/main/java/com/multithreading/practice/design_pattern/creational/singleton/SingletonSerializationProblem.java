package com.multithreading.practice.design_pattern.creational.singleton;

import java.io.*;
import java.nio.file.Files;

public class SingletonSerializationProblem {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DateUtilSingletonSerializable instance1 = DateUtilSingletonSerializable.getInstance();

        ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(new File("C:\\Users\\Omid\\Desktop\\folders\\projects\\hacker-rank\\multi-threading\\src\\main\\resources\\file.ser").toPath()));
        outputStream.writeObject(instance1);
        DateUtilSingletonSerializable instance2 = DateUtilSingletonSerializable.getInstance();
        ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(new File("C:\\Users\\Omid\\Desktop\\folders\\projects\\hacker-rank\\multi-threading\\src\\main\\resources\\file.ser").toPath()));
        instance2= (DateUtilSingletonSerializable)inputStream.readObject();

        System.out.println(instance1==instance2); // it is false
        outputStream.close();
        inputStream.close();




        DateUtilSingletonSerializableSolved instance11 = DateUtilSingletonSerializableSolved.getInstance();
        ObjectOutputStream outputStream1 = new ObjectOutputStream(Files.newOutputStream(new File("C:\\Users\\Omid\\Desktop\\folders\\projects\\hacker-rank\\multi-threading\\src\\main\\resources\\file2.ser").toPath()));
        outputStream1.writeObject(instance11);
        DateUtilSingletonSerializableSolved instance12 = DateUtilSingletonSerializableSolved.getInstance();
        ObjectInputStream inputStream11 = new ObjectInputStream(Files.newInputStream(new File("C:\\Users\\Omid\\Desktop\\folders\\projects\\hacker-rank\\multi-threading\\src\\main\\resources\\file2.ser").toPath()));
        instance12= (DateUtilSingletonSerializableSolved)inputStream11.readObject();
        System.out.println(instance11==instance12); // it is now true

        inputStream11.close();
        outputStream1.close();
    }
}
