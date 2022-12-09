package com.multithreading.practice.sum;

public class SumMain {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        System.out.println("must be: "+sum);
        ParallelSum parallelSum = new ParallelSum(Runtime.getRuntime().availableProcessors());
        parallelSum.calculateSum(array);
    }
}
