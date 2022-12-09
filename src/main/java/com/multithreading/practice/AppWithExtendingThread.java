package com.multithreading.practice;
class Runner3 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                //ceasing the execution
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("runner1: " + i);
        }
    }
}
class Runner4 extends  Thread{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("runner2: " + i);
        }

    }
}
public class AppWithExtendingThread {
    public static void main(String[] args) {
        Thread thread1 = new Runner3();
        Thread thread2 = new Runner4();
        thread1.start();
        thread2.start();

        // we can wait for the thread1 to finish: join()
        try {
            thread1.join();
//            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("finished with threads ...");
    }
}
