package com.multithreading.practice;

public class AppWithSynchronizationProblem {
    public static int counter1 = 0;
    public static int counter2 = 0;

    // because AppWithSynchronizationProblem object has a single lock:
    // this is why the methods(increment1() and increment2()) cannot
    // be executed at the same time

    // to solve this problem we should remove synchronized keyword from the second method
    // so that it no longer needs to acquire the AppWithSyncronizationProblem object lock

//    public static synchronized void increment1() {
//        counter++;
//    }
//

    // it is not a good practice to use the synchronized key word
    // it is better to use synchronized blocks
    public static void increment1() {
//        counter1++;
        // class level locking
        // we synchronize blocks that are 100% necessary
        // se are not going to synchronize the whole method
        synchronized (AppWithSynchronizationProblem.class) {
            counter1++;
        }
    }


//    public static synchronized void increment2() {
//        counter2++;
//    }

    public static void increment2() {
        synchronized (AppWithSynchronizationProblem.class) {
            counter2++;
        }
    }

    public static void process() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                counter++;
                increment1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                counter++;
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
