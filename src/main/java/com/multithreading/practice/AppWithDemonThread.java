package com.multithreading.practice;
class DemonWorker implements Runnable{

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("demon thread is running ...");
        }
    }
}
class NormalWorker implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("normal thread finished execution ...");
    }
}
public class AppWithDemonThread {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new DemonWorker());
        Thread thread2 = new Thread(new NormalWorker());
        thread1.setDaemon(true);
        thread1.start();
        thread2.start();

        // the demon threads are going to be terminated by the JVM when all worker threads finish execution
    }

}
