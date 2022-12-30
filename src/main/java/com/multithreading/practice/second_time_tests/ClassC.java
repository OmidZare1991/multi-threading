package com.multithreading.practice.second_time_tests;

public class ClassC  implements Runnable{
    private int counter;
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized(ClassC.class){
            counter++;
            System.out.println("in block " + Thread.currentThread().getName());
            System.out.println("in block " + Thread.currentThread().getName() + " end"+ counter);
        }
    }
}
