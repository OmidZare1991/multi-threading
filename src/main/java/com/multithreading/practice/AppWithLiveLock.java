package com.multithreading.practice;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AppWithLiveLock {
    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        AppWithLiveLock liveLock = new AppWithLiveLock();
        new Thread(liveLock::worker1,"worker1").start();
        new Thread(liveLock::worker2,"worker2").start();
    }

    public void worker1() {
        while (true) {
            try {
                lock1.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("worker1 acquires lock1...");
            System.out.println("worker1 tries to get lock2 ...");
            if(lock2.tryLock()){
                System.out.println("worker1 acquires lock2 ...");
                lock2.unlock();
            }else {
                System.out.println("worker1 cannot acquire lock2 ...");
                continue;
            }
            lock1.unlock();
            lock2.unlock();
        }
    }

    public void worker2() {
        while (true) {
            try {
                lock2.tryLock(50, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("worker2 acquires lock2...");
            System.out.println("worker2 tries to get lock1 ...");
            if(lock1.tryLock()){
                System.out.println("worker2 acquires lock1 ...");
                lock1.unlock();
            }else {
                System.out.println("worker2 cannot acquire lock1 ...");
                continue;
            }
            lock1.unlock();
            lock2.unlock();
        }
    }
}
