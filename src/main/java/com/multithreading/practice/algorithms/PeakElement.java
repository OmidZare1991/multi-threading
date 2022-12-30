package com.multithreading.practice.algorithms;

//The following corner cases give a better idea about the problem:
//If the input array is sorted in a strictly increasing order, the last element is always a peak element. For example, 50 is peak element in {10, 20, 30, 40, 50}.
//If the input array is sorted in a strictly decreasing order, the first element is always a peak element. 100 is the peak element in {100, 80, 60, 50, 20}.
//If all elements of the input array are the same, every element is a peak element.
public class PeakElement {
    public static void main(String[] args) {

    }

    private int findPeakElement(int[] array) {
        int length = array.length;
        // First or last element is peak element
        if (length == 1) {
            return 0;
        }
        if(array[0]>=array[1]){
            return 0;
        }
        if(array[length-1]>=array[length-2]){
            return length-2;
        }
        // Check for every other element
        for(int i=1;i<length-2;i++){
            if(array[i]>=array[i-1] && array[i]>=array[i+1]){
                return i;
            }
        }
        return 0;
    }
}
