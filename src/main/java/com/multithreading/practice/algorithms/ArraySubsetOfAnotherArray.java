package com.multithreading.practice.algorithms;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

//check whether a2[] is a subset of a1[] or not
public class ArraySubsetOfAnotherArray {
    public static void main(String[] args) {
//        int [] array1={11, 1, 13, 21, 3, 7};
//        int [] array2={11, 3, 7, 1};
//        System.out.println(isSubset(array1,array2));

//        int [] array1={1, 2, 3, 4, 5, 6};
//        int [] array2={1, 2, 4};
//        System.out.println(isSubset(array1,array2));


        int [] array1={10, 5, 2, 23, 19};
        int [] array2={19, 5, 3};
        System.out.println(isSubset(array1,array2));
    }

    private static boolean isSubset(int[] array1, int[] array2) {
        List<Integer> list = new ArrayList<>();
        for (int item : array1) {
            list.add(item);
        }
        for (int item : array2) {
            if (!list.contains(item)) {
                return false;
            }
        }
        return true;
    }
}
