package com.multithreading.practice;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {
    private int id;

    public Task(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("task with id " + id + "is in work- threadId: " + Thread.currentThread());
        long l = (long) Math.random() * 5;
        try {
            TimeUnit.SECONDS.sleep(l);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class AppWithSingleThreadExecutor {
    public static void main(String[] args) {
        // it is a single thread that will execute the tasks sequentially
        // so one after another

        //Creates an Executor that uses a single worker thread operating off an unbounded queue.
        // (Note however that if this single thread terminates due to a failure during execution prior to shutdown,
        // a new one will take its place if needed to execute subsequent tasks.)
        // Tasks are guaranteed to execute sequentially, and no more than one task will be active at any given time.
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task(i));
        }
    }
}
