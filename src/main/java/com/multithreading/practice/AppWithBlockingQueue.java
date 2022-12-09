package com.multithreading.practice;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class QueueWorker1 implements Runnable {
    private BlockingQueue<Integer> queue;
    private int count = 0;

    public QueueWorker1(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("putting item in the queue: " + count);
            queue.add(count);
            count++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class QueueWorker2 implements Runnable {
    private BlockingQueue<Integer> queue;

    public QueueWorker2(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer take = queue.take();
                System.out.println("taking from the queue " + take);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class AppWithBlockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue(10);
        new Thread(new QueueWorker1(queue)).start();
        new Thread(new QueueWorker2(queue)).start();
    }
}
