package com.multithreading.practice.algorithms;

public class SlidingWindowMaxOfNConsecutiveNums {
    public static void main(String[] args) {
        int arr[] = {100, 200, 300, 400};
        int maxOfNConsecutiveNumbers = findMaxOfNConsecutiveNumbers(arr, 2);
        System.out.println("max is : "+maxOfNConsecutiveNumbers);
    }

    private static int findMaxOfNConsecutiveNumbers(int[] array, int n) {
        if (array.length < n) {
            return -1;
        } else if (array.length == n) {
            return getSum(array, 0, array.length);
        } else {

            int currentSum = getSum(array, 0, n);
            int maxSum = Integer.MIN_VALUE;
            for (int i = 1; i <= array.length - n; i++) {
                currentSum -= array[i-1];
                currentSum += array[i + (n-1)];
                maxSum = Math.max(maxSum, currentSum);
            }
            return maxSum;
        }
    }

    private static int getSum(int[] array, int startIndex, int endindex) {
        int sum = 0;
        for (int i = startIndex; i < endindex; i++) {
            sum += array[i];
        }
        return sum;
    }
}
