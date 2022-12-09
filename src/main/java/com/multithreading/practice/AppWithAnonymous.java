package com.multithreading.practice;

public class AppWithAnonymous {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("runner1: "+i);
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("runner2: " + i);
            }
        });
        thread1.start();
        thread2.start();
    }
}
