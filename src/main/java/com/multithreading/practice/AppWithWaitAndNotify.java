package com.multithreading.practice;

// use wait and notify when using the same lock monitor ( in this case the Process object)
class Process{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.out.println("running the produce method ...");
            wait();
            System.out.println("again running the produce method ...");
        }
    }
    public void consume() throws InterruptedException {
        Thread.sleep(1000);
        synchronized (this){
            System.out.println("consume method is executed ...");
            // it is not going to handle the lock immediately: we can make further operations
            // after the notify method java is going to execute the other lines of code in the synchronized block (in this case sleep)
            // until it finished with the synchronized block
            notify();
            Thread.sleep(3000);
        }
    }
}
public class AppWithWaitAndNotify {
    public static void main(String[] args) {
        Process process = new Process();
        Thread thread1 = new Thread(() -> {
            try {
                process.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                process.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.start();
        thread2.start();
    }
}
