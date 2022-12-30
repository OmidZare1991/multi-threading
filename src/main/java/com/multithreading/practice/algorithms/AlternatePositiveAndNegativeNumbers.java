package com.multithreading.practice.algorithms;
//Given an unsorted array Arr of N positive and negative numbers.
//Your task is to create an array of alternate positive and negative numbers
//without changing the relative order of positive and negative numbers.
//Note: Array should start with a positive number.
/*
we need to maintain the relative order of
postive elements and negative elements we will pick
each element from the positive and negative and will
store them
 */

import java.util.ArrayList;
import java.util.List;

public class AlternatePositiveAndNegativeNumbers {
    public static void main(String[] args) {
        int [] array = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        rearrange(array);
        System.out.println();
        int [] array2 ={-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(array2);
    }

    private static void rearrange(int[] array) {
        List<Integer> positiveNumbers = new ArrayList<>();
        List<Integer> negativeNumbers = new ArrayList<>();

        for (int item : array) {
            if (item >= 0) {
                positiveNumbers.add(item);
            } else {
                negativeNumbers.add(item);
            }
        }
        int i, j = 0, k = 0;
        for (i = 0; i < array.length && j < positiveNumbers.size() && k < negativeNumbers.size(); i += 2) {
            array[i] = positiveNumbers.get(j++);
            array[i + 1] = negativeNumbers.get(k++);
        }
        while (j < positiveNumbers.size()) {
            array[i++] = positiveNumbers.get(j++);
        }
        while (k < negativeNumbers.size()) {
            array[i++] = negativeNumbers.get(k++);
        }

        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}
