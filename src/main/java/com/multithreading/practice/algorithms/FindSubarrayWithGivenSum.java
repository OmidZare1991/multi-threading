package com.multithreading.practice.algorithms;

public class FindSubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 7, 5}; // 2 4
        int[] result = subarraySum(array, 5, 12);

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 1 5
//        int[] result = subarraySum(array, 10, 15);

//
//        int[] array= { 15, 2, 4, 8, 9, 5, 10, 23 }; // 2 5
//        int[] result = subarraySum2(array, 8, 23);


//        int[] array = {1, 2, 3, 7, 5}; // 2 4
//        int[] result = subarraySum2(array, 5, 12);

//        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 1 5
//        int[] result = subarraySum2(array, 10, 15);

        for (int index : result) {
            System.out.print(index + " ");
        }
    }

    // first solution
    private static int[] subarraySum(int[] array, int n, int s) {
        for (int i = 0; i < n - 2; i++) {
            int sum = array[i];
            for (int j = i + 1; j < n - 1; j++) {
                if (sum < s) {
                    sum += array[j];
                }
                if (sum == s) {
                    int[] result = new int[2];
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        int[] result = new int[1];
        result[0] = -1;
        return result;
    }

    // second solution (sliding window)
    private static int[] subarraySum2(int[] array, int n, int s) {
        int sum = array[0];
        int startPoint = 0;
        for (int i = 1; i <= n - 1; i++) {
            if (sum == s) {
                return getIndexes(startPoint + 1, i);
            }
            if (sum > s) {
                sum -= array[startPoint++];
                if (sum == s) {
                    return getIndexes(startPoint + 1, i);
                }
            }
            if (i != n - 1) {
                sum += array[i];
            }
        }
        while (startPoint != n - 1) {
            if (sum > s) {
                sum -= array[startPoint++];
            }
            if (sum == s) {
                return getIndexes(startPoint + 1, n - 1);
            }
        }
        int[] result = new int[1];
        result[0] = -1;
        return result;
    }

    private static int[] getIndexes(int startIndex, int endIndex) {
        int[] result = new int[2];
        result[0] = startIndex;
        result[1] = endIndex;
        return result;
    }
}
