package com.multithreading.practice;

public class AppWithSynchronizationProblemSolved {
    public static int counter1 = 0;
    public static int counter2 = 0;
    private static final Object OBJECT1 = new Object();
    private static final Object OBJECT2 = new Object();

    public static void increment1() {
        // at the same time != parallel - since CPU uses time slicing algorithm
        synchronized (OBJECT1) {
            counter1++;
        }
    }

    public static void increment2() {
        synchronized (OBJECT2) {
            counter2++;
        }
    }

    public static void process() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increment2();
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("the counter is : " + counter1);
        System.out.println("the counter is : " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
