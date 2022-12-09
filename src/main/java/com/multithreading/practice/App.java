package com.multithreading.practice;

class Runner1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("runner1: " + i);
        }
    }
}

class Runner2 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("runner2: " + i);
        }

    }
}

public class App {
    public static void main(String[] args) {
        // achieving multi-threading
        // it is not parallel execution
        Thread thread1 = new Thread(new Runner1());
        Thread thread2 = new Thread(new Runner2());
        thread1.start();
        thread2.start();
    }

}
