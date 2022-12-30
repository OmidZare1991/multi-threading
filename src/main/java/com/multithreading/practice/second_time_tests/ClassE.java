package com.multithreading.practice.second_time_tests;

public class ClassE implements Runnable {
    private static int counter;
    public int counter2;

    private static void increment() {
        System.out.println(Thread.currentThread().getName()+ " in increment()");
        synchronized (ClassE.class) {
            counter++;
            System.out.println("in block1 " + Thread.currentThread().getName());
            System.out.println("in block1 " + Thread.currentThread().getName() + " end1 with value: " + counter);
        }
    }

    private void increment2() {
        System.out.println(Thread.currentThread().getName()+" in increment2()");
        synchronized (this) {
            counter2++;
            System.out.println("in block2 " + Thread.currentThread().getName());
            System.out.println("in block2 " + Thread.currentThread().getName() + "  end1 with value: " + counter2);
        }
    }

    @Override
    public void run() {
        increment();
        increment2();
    }
}

