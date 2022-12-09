package com.multithreading.practice.sorting;

import java.util.Random;

public class SortingMain {
    private static Random random = new Random();
    public static void main(String[] args) {
//        int i1 = Runtime.getRuntime().availableProcessors();
//        Random random = new Random();
//        int array[] = new int[10];
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(1000) - 50;
//        }
//        MergeSorting sorting = new MergeSorting(array);
//        sorting.mergeSort(0,array.length-1);
//        sorting.showResult();

        int numberOfThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("number of threads : " + numberOfThreads);

//        System.out.println("hey start");
        int[] numbers = ceateRandomArray();
//        System.out.println("hey end");
//        MergeSorting sorting = new MergeSorting(numbers);
//        long startTime = System.currentTimeMillis();
//        sorting.mergeSort(0, numbers.length - 1);
//        long endTime = System.currentTimeMillis();
//        sorting.showResult();
//        System.out.println();
//        System.out.println("time taken to sort 100 000 000 items sequentially: " + (endTime - startTime));


        ParallelWithMergeSort parallelWithMergeSort = new ParallelWithMergeSort(numbers);
        long startTime2 = System.currentTimeMillis();
        parallelWithMergeSort.parallelMergeSort(0, numbers.length - 1, numberOfThreads);
        long endTime2 = System.currentTimeMillis();
        parallelWithMergeSort.showResult();
        System.out.println();

        System.out.println("time taken to sort 100 000 000 items in a parallel way: " + (endTime2 - startTime2));

    }

    public static int[] ceateRandomArray() {
        int a[] = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = random.nextInt(100000);
        }
        return a;
    }
}
