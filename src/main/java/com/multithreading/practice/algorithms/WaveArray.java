package com.multithreading.practice.algorithms;

/*
Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array(In Place).
In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
 */
public class WaveArray {
    public static void main(String[] args) {
        int [] array= {2,4,7,8,9,10};
        int [] array2={1,2,3,4,5};
        convertToWave(array);
        System.out.println();
        convertToWave(array2);
    }

    private static void convertToWave(int[] array) {
        int tempt = 0;
        for (int i = 0; i <array.length - 1; i += 2) {
            tempt = array[i];
            array[i] = array[i + 1];
            array[i + 1] = tempt;
        }
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
