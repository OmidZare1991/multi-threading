package com.multithreading.practice.algorithms;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] array = {1, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeated(array));

        int[] array2 = {1, 2, 3, 4};
        System.out.println(firstRepeated(array2));
    }

    private static int firstRepeated(int[] array) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int firstItem = -1;
        for (int item : array) {
            map.merge(item, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if (value > 1) {
                firstItem = entry.getKey();
                break;
            }
        }
        if (firstItem == -1) {
            return firstItem;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == firstItem) {
                return i;
            }
        }
        return firstItem;
    }
}
