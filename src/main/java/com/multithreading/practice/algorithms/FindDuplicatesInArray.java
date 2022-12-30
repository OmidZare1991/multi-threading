package com.multithreading.practice.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicatesInArray {
    public static void main(String[] args) {
        int array[] = {2,3,1,2,3};
        System.out.println(duplicates(array,array.length)); // 2 3
        int [] array2= {0,3,1,2};
        System.out.println(duplicates(array2,array2.length)); // -1

    }

    private static List<Integer> duplicates(int[] array, int n) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int item : array) {
            map.merge(item, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > 1) {
                result.add(entry.getKey());
            }
        }
        if (result.isEmpty()) {
            result.add(-1);
            return result;
        }
        return result;
    }
}
