package com.multithreading.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppWithLock {
    private static int counter = 0;
    // it has the same behavior as synchronized approach
    // it has some additional features
    // new ReentrantLock(boolean fairnessParameter) -->
    // fairnessParameter: if it is set be true--> the longest waiting thread will get the lock
    // if is set to be false ---> there is no access order

    //important: we have to use try catch block when doing critical section that may throw exceptions
    // we call unlock() in the finally block
    private static Lock lock = new ReentrantLock();

    private static void increment() {
        lock.lock();

        try {
            for (int i = 0; i < 10000; i++)
                counter++;
        }finally {
            lock.unlock(); // we can use unlock() in any part (methods) of the code to unlock
        }
    }

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

        System.out.println("counter is : " + counter);
    }
}
