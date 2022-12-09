package com.multithreading.practice;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Worker {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void producer() throws InterruptedException {
        lock.lock();
        System.out.println("producer method ....");
        condition.await();
        System.out.println("producer method again ...");
        lock.unlock();
    }

    public void consumer() throws InterruptedException {
        lock.lock();
        Thread.sleep(2000);
        System.out.println("consumer method ...");
        condition.signal();
        lock.unlock();
    }
}

public class AppWithProducerAndConsumerWithLock {
    public static void main(String[] args) {
        Worker worker = new Worker();
        Thread thread1 = new Thread(()->{
            try {
                worker.producer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(()->{
            try {
                worker.consumer();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
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
    }
}
