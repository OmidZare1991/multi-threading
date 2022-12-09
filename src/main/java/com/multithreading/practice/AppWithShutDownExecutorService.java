package com.multithreading.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class WorkerShutdown implements Runnable {
    private int id;

    public WorkerShutdown(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("task with id " + id + "is in work- threadId: " + Thread.currentThread());
        long l = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(l);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class AppWithShutDownExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new WorkerShutdown(i));
        }
        //prevent the executor to execute any further tasks
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
