package com.multithreading.practice.second_time_tests;

public class ClassD implements Runnable {
    private static int counter;

    private static void increment() {
        System.out.println(Thread.currentThread().getName());
        synchronized (ClassD.class) {
            counter++;
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end" + counter);
        }
    }

    @Override
    public void run() {
        increment();
    }
}
