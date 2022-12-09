package com.multithreading.practice;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//this is used to synchronize one or more tasks by forcing them to wait for the completion a set of operations
// being performed by other tasks.
// you give an initial count to a CountDownLatch object and any task that calls await() on that object
// will block until the count reaches zero.

// a CountDownLatch cannot be reset!!! you can use CyclicBarrier instead.

class LatchWorker implements Runnable{
private CountDownLatch latch;
private int id;

    public LatchWorker(CountDownLatch latch, int id) {
        this.latch = latch;
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("worker with id: "+id+ " is running ...");
        latch.countDown();
    }
}
public class AppWithCountDownLatch {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            executorService.execute(new LatchWorker(latch,i+1));
        }
        try {
            // hold all other tasks until the count reaches zero ; when all tasks finished executing
            // when all five tasks are finished with execution then the rest of tasks start executing
            // (line 45 starts executing when all five tasks are done).
            // it actually holds the main thread until the five worker thread are finished executing( when the counter
            // reaches zero)
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All prerequisites done ...");
        executorService.shutdownNow();
    }
}
