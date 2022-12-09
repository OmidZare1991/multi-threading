package com.multithreading.practice;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
// threads must get the locks in the same order : to solve the problem
public class AppWithDeadlockSolved {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        AppWithDeadlock deadlock = new AppWithDeadlock();
        new Thread(deadlock::worker1).start();
        new Thread(deadlock::worker2).start();
    }

    public void worker1() {
        lock1.lock();
        System.out.println("worker1 acquires the lock1...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("worker1 acquires the lock2...");
        lock1.unlock();
        lock2.unlock();
    }

    public void worker2() {
        lock1.lock();
        System.out.println("worker2 acquires the lock1...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        lock2.lock();
        System.out.println("worker2 acquires the lock2...");
        lock2.unlock();
        lock1.unlock();
    }
}
