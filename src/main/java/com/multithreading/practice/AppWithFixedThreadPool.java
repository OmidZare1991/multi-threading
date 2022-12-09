package com.multithreading.practice;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WorkerThread implements Runnable {
    private int id;
    private int count = 0;

    public WorkerThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        count = count + 2;
        System.out.println("task with id " + id + "is in work- threadId: " + Thread.currentThread().getId() + " count: " + count);
        long l = (long) Math.random() * 5;
        try {
//            TimeUnit.SECONDS.sleep(l);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class AppWithFixedThreadPool {
    static int count =0;

    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println(Thread.currentThread().getId()+": "+count++);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 20; i++) {
//            executorService.execute(new WorkerThread(i));
            executorService.execute(thread);
        }


    }
}
