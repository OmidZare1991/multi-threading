package com.multithreading.practice;

import java.util.Random;
import java.util.concurrent.*;

class BarrierWorker implements Runnable {
    private int id;
    private CyclicBarrier cyclicBarrier;
    private Random random;

    public BarrierWorker(int id, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        System.out.println("worker with id " + id + " is running with threadId: "+Thread.currentThread().getId());

        try {
            Thread.sleep(random.nextInt(3000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            cyclicBarrier.await();
            // this line ie executed when all thread are done with their tasks
            System.out.println("after wait ....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

public class AppWithCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> {
            System.out.println("all tasks are done ...");
        });
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new BarrierWorker(i + 1, cyclicBarrier));
        }
        executorService.shutdown();
    }

}
