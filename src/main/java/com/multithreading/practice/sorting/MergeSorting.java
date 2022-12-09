package com.multithreading.practice.sorting;

public class MergeSorting {
    private int[] array;
    private int tempArray[];

    public MergeSorting(int[] array) {
        this.array = array;
        this.tempArray = new int[array.length];
    }

    public void showResult() {
        for (int item : array) {
            System.out.print(item + ", ");
        }
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
