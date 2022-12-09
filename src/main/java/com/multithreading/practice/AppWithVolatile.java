package com.multithreading.practice;

class MyWorker implements Runnable {
    // it will be stored in the main memory: the thread is not going to cache it
    private volatile boolean terminated;

    @Override
    public void run() {
        while (!terminated) {
            System.out.println("worker is running ...");
        }
    }

    public boolean isTerminated() {
        return terminated;
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }
}

public class AppWithVolatile {

    public static void main(String[] args) throws InterruptedException {
        MyWorker worker = new MyWorker();
        Thread thread = new Thread(worker);

        thread.start();

        Thread.sleep(2000);

        worker.setTerminated(true);
        System.out.println("Algorithm is terminated ...");
    }

}
