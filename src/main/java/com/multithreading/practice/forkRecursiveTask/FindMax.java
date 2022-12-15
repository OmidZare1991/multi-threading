package com.multithreading.practice.forkRecursiveTask;

import java.util.concurrent.RecursiveTask;

import static com.multithreading.practice.forkRecursiveTask.FindMaxMain.THRESHOLD;

public class FindMax extends RecursiveTask<Integer> {
    private int[] numbers;
    private int lowIndex;
    private int highIndex;

    public FindMax(int[] numbers, int lowIndex, int highIndex) {
        this.numbers = numbers;
        this.lowIndex = lowIndex;
        this.highIndex = highIndex;
    }

    @Override
    protected Integer compute() {
        if (highIndex - lowIndex < THRESHOLD) {
            return sequentialFindMax();
        } else {
            int mid = (highIndex + lowIndex) / 2;
            FindMax findMax1 = new FindMax(numbers, lowIndex, mid);
            FindMax findMax2 = new FindMax(numbers, mid + 1, highIndex);

//            findMax1.fork();
//            findMax2.fork();
//
//            Integer max1 = findMax1.join();
//            Integer max2 = findMax2.join();
            invokeAll(findMax1, findMax2);

//            return Math.max(max1, max2);
            return Math.max(findMax1.join(), findMax2.join());
        }
    }

    private int sequentialFindMax() {
        int max = numbers[lowIndex];
        for (int i = lowIndex + 1; i < highIndex; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
