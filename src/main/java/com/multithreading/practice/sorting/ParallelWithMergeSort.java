package com.multithreading.practice.sorting;

public class ParallelWithMergeSort {
    private int[] array;
    private int tempArray[];

    public ParallelWithMergeSort(int[] array) {
        this.array = array;
        this.tempArray = new int[array.length];
    }

    public void showResult() {
        for (int item : array) {
            System.out.print(item + ", ");
        }
    }

    public void parallelMergeSort(int low, int high, int numberOfThreads) {
        System.out.println("start with number of thread: "+numberOfThreads);
        if (numberOfThreads <= 1) {
            mergeSort(low, high);
            return;
        }
        int mid = (low + high) / 2;
        Thread leftSorter = mergeSortParallel(low, mid, numberOfThreads,"left");
//        System.out.println("leftSorter: "+leftSorter.getId());
        Thread rightSorter = mergeSortParallel(mid + 1, high, numberOfThreads,"right");
//        System.out.println("rightSorter: "+rightSorter.getId());
        leftSorter.start();
        rightSorter.start();
        try {
            leftSorter.join();
            rightSorter.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        merge(low, mid, high);
    }

    Thread mergeSortParallel(int low, int high, int numberOfThreads,String which) {
//        System.out.println(which+ ": "+numberOfThreads);
        return new Thread(() -> {
            parallelMergeSort(low, high, numberOfThreads / 2);
        });
    }

    public void mergeSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(low, mid);
        mergeSort(mid + 1, high);
        merge(low, mid, high);
    }

    private void merge(int low, int mid, int high) {
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = array[i];
        }
        int i = low;
        int j = mid + 1;
        int k = low;
        while (i <= mid && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            array[k] = tempArray[i];
            i++;
            k++;
        }

        while (j <= high) {
            array[k] = tempArray[j];
            j++;
            k++;
        }
    }
}
