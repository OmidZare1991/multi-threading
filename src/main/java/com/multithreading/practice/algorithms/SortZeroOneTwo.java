package com.multithreading.practice.algorithms;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] array = {0, 2, 1, 2, 0};
        sort012(array, array.length);
//        int [] array2={0,1,0};
//        sort012(array2, array2.length);

//        int[] array3 = {0, 0, 2, 0, 1, 2};
//        sort012(array3, array3.length);

    }

    private static void sort012(int[] array, int n) {
        int countZero = 0, countOne = 0, countTwo = 0;
        for (int item : array) {
            switch (item) {
                case 0:
                    countZero++;
                    break;
                case 1:
                    countOne++;
                    break;
                case 2:
                    countTwo++;
                    break;
            }
        }
        int i = 0;
        while (countZero > 0) {
            array[i++] = 0;
            countZero--;
        }
        while (countOne>0){
            array[i++]=1;
            countOne--;
        }
        while (countTwo>0){
            array[i++]=2;
            countTwo--;
        }

        for(int item: array){
            System.out.print(item+ " ");
        }
    }
}
