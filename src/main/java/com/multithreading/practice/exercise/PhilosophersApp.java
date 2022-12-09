package com.multithreading.practice.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.multithreading.practice.exercise.Constants.*;

public class PhilosophersApp {
    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[0];
        Chopstick[] chopsticks;
        ExecutorService executorService = null;
        try {
            philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];
            chopsticks = new Chopstick[NUMBER_OF_CHOPSTICKS];
            executorService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);
            for (int i = 0; i < NUMBER_OF_CHOPSTICKS; i++) {
                chopsticks[i] = new Chopstick(i);
            }
            for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
                philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % NUMBER_OF_CHOPSTICKS]);
                executorService.execute(philosophers[i]);
            }
            Thread.sleep(SIMULATION_RUNNING_TIME);
            executorService.shutdown();

            for (Philosopher philosopher : philosophers) {
                philosopher.setFull(true);
            }

        } finally {
            executorService.shutdown();
            while (!executorService.isTerminated()) {
                Thread.sleep(1000);
            }
            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher + " ate #" + philosopher.getEatingCounter());
            }
        }
    }
}
