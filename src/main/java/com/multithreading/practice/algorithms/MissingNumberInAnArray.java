package com.multithreading.practice.algorithms;

public class MissingNumberInAnArray {
    public static void main(String[] args) {
//        int [] array= {1,2,3,5}; //4
//        System.out.println(missingNumber(array, 5));


        int[] array = {6, 1, 2, 8, 3, 4, 7, 10, 5}; //9
        System.out.println(missingNumber(array, 10));
    }

    private static int missingNumber(int[] array, int n) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += array[i];
        }
        int realSum = n * (n + 1) / 2;
        return realSum - sum;
    }
}
