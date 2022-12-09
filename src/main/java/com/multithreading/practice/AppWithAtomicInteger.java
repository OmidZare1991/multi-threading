package com.multithreading.practice;

import java.util.concurrent.atomic.AtomicInteger;

public class AppWithAtomicInteger {
    // with Atomic types we no longer need synchronized methods or blocks
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            increment();
        });
        Thread thread2 = new Thread(() -> {
            increment();
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(counter);
    }

    public static void increment() {
        for (int i = 0; i < 1000; i++) {
            counter.getAndIncrement();
        }
    }
}
