package com.multithreading.practice.sum;

public class ParallelSum {
    private SumWorker[] sumWorkers;
    private int numberOfThreads;

    public ParallelSum(int numberOfThreads) {
        this.numberOfThreads = numberOfThreads;
        this.sumWorkers = new SumWorker[numberOfThreads];
    }

    public void calculateSum(int[] array) {
        int steps = (int) Math.ceil(array.length * 1.0 / numberOfThreads);
        for (int i = 0; i < numberOfThreads; i++) {
            sumWorkers[i] = new SumWorker(array, i * steps, (i + 1) * steps);
            sumWorkers[i].start();
        }
        for (int i = 0; i < numberOfThreads; i++) {
            try {
                sumWorkers[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int finalSum = 0;
        for (int i = 0; i < numberOfThreads; i++) {
            finalSum += sumWorkers[i].getWorkerSums();
        }
        System.out.println("finalSum: "+ finalSum);
    }
}
