package com.multithreading.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Test implements Runnable {
    private int id;
    private volatile boolean flag;

    public Test(int id) {
        this.id = id;
    }

    public void setCounter(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        while (!flag) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getId() + ": on object: " + id + flag);
        }
    }

    @Override
    public String toString() {
        return "Test " + id;
    }
}

public class VolatileBetterExample {
    public static void main(String[] args) {
        Test[] test = new Test[5];
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            test[i] = new Test(i);
            executorService.execute(test[i]);
        }
        test[0].setCounter(true);
    }
}
