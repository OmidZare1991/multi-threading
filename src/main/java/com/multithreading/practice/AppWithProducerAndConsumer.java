package com.multithreading.practice;

import java.util.ArrayList;
import java.util.List;

class Processor{
    private List<Integer> list = new ArrayList<>();
    private final Object lock = new Object();
    private static final int UPPER_LIMIT =5;
    private static final int LOWER_LIMIT =0;
    private int value =0;
    public void producer() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    System.out.println("waiting for removing items ...");
                    lock.wait();
                } else {
                    System.out.println("adding values ..." + value);
                    list.add(value);
                    value++;
                    lock.notify();
                    // do further operation !!! ( in this case while loop)
                }
                Thread.sleep(1000);
            }
        }
    }
    public void consumer() throws InterruptedException{
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("waiting for adding items ...");
                    lock.wait();
                } else {
                    System.out.println("removing ... " + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(1000);
            }
        }
    }
}
public class AppWithProducerAndConsumer {
    public static void main(String[] args) {
        Processor processor = new Processor();
        Thread thread1 = new Thread(()->{
            try {
                processor.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                processor.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        thread1.start();
        thread2.start();
    }
}
