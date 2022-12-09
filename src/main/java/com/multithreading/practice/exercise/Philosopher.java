package com.multithreading.practice.exercise;

import java.util.Random;

import static com.multithreading.practice.exercise.State.LEFT;
import static com.multithreading.practice.exercise.State.RIGHT;

public class Philosopher implements Runnable {
    private int id;
    private int eatingCounter;
    private volatile boolean full;
    private Random random;
    private Chopstick leftChopstick;
    private Chopstick rightChopstick;

    public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
        this.random = new Random();
    }

    private void think() {
        System.out.println(this + " is thinking ...");
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        System.out.println(this + " is eating ...");
        eatingCounter++;
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public int getEatingCounter() {
        return eatingCounter;
    }

    @Override
    public void run() {
        System.out.println("*************************** " + Thread.currentThread().getId() + ": " + full);
        while (!full) {
            think();
            try {
                // if philosopher is able to acquire the left chopstick
                if (leftChopstick.pickUp(this, LEFT)) {
                    if (rightChopstick.pickUp(this, RIGHT)) {
                        eat();
                        rightChopstick.putDown(this, RIGHT);
                    }
                    leftChopstick.putDown(this, LEFT);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Philosopher " + id;
    }
}
