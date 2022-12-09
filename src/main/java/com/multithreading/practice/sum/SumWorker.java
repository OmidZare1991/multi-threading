package com.multithreading.practice.sum;

public class SumWorker extends Thread {
    private int[] array;
    private int low;
    private int high;
    private int workerSums;

    public SumWorker(int[] array, int low, int high) {
        this.array = array;
        this.low = low;
        this.high = high;
    }

    public int getWorkerSums() {
        return workerSums;
    }

    @Override
    public void run() {
        workerSums = 0;
        for (int i = low; i < high; i++) {
            workerSums += array[i];
        }
    }
}
