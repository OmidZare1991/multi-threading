package com.multithreading.practice;

public class AppWithSyncronization {
    public static int counter = 0;

    // to make sure this method is executed only by a single thread at a given time
    public static synchronized void increment(){
        counter++;
    }
    public static void process() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                counter++;
                increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
//                counter++;
                increment();
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
        System.out.println("the counter is : " + counter);
    }

    public static void main(String[] args) {
        process();
    }
}
