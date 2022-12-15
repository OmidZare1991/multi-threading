package com.multithreading.practice.forkRecursiveTask;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class FindMaxMain {
    public static Integer THRESHOLD = 0;

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        int[] nums = getNums();
        FindMax findMax = new FindMax(nums, 0, nums.length);
        THRESHOLD = nums.length / Runtime.getRuntime().availableProcessors();
        Integer maxNumber = forkJoinPool.invoke(findMax);
        System.out.println("max is : " + maxNumber);
    }

    private static int[] getNums() {
        Random random = new Random();
        int nums[] = new int[1000];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(1000);
        }
        return nums;
    }
}
