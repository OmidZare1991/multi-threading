package com.multithreading.practice.forkRecursiveTask;

import java.util.concurrent.ForkJoinPool;

public class RecursiveTaskMain {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
//        SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(20);
//        Integer invoke = forkJoinPool.invoke(simpleRecursiveTask);
//        System.out.println("result: "+invoke);

        SimpleRecursiveTask simpleRecursiveTask = new SimpleRecursiveTask(200);
        Integer invoke2 = forkJoinPool.invoke(simpleRecursiveTask);
        System.out.println("result: "+invoke2);
    }
}
