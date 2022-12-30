package com.multithreading.practice.algorithms;

import java.util.HashMap;
import java.util.Map;

public class CountPairsWithGivenSum {
    public static void main(String[] args) {
//        int[] array = {1, 5, 7, 1};
//        Map<Integer, Integer> pairsCount = getPairsCount(array, array.length, 6);
//        System.out.println(pairsCount);

//        int[] array2 = {1, 1, 1, 1};
//        int count = getPairsCount(array2, array2.length, 2);
//        System.out.println(count);


        int[] array2 = {1, 1, 1, 1};
        int count = getPairsCount2(array2, array2.length, 2);
        System.out.println(count);
    }

    private static int getPairsCount(int[] array, int n, int k) {
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (array[i] + array[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // using hashing
    private static int getPairsCount2(int[] array, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int counter = 0;
        // Store counts of all elements in map
        for (int item : array) {
            map.merge(item, 1, Integer::sum);
        }

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (map.containsKey(k - array[i])) {
                counter += map.get(k - array[i]);
            }
            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (k - array[i] == array[i]) {
                counter--;
            }
        }
        return counter / 2;
    }
}