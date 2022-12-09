package com.multithreading.practice;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayedWorker implements Delayed {
    private long duration;
    private String message;

    public DelayedWorker(long duration, String message) {
        this.duration = System.currentTimeMillis() + duration;
        this.message = message;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(duration - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed otherDelayed) {
        if (this.duration < ((DelayedWorker) otherDelayed).getDuration()) {
            return -1;
        }
        if (duration > ((DelayedWorker) otherDelayed).getDuration()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return message;
    }
}

public class AppWithDelayedQueue {
    public static void main(String[] args) {
        BlockingQueue<DelayedWorker> queue = new DelayQueue<>();

        try {
            queue.put(new DelayedWorker(1000, "first worker ..."));
            queue.put(new DelayedWorker(3000, "second worker ..."));
            queue.put(new DelayedWorker(2000, "third worker ...."));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        while (!queue.isEmpty()) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
