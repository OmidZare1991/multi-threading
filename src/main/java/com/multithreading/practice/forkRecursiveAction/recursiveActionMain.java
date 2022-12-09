package com.multithreading.practice.forkRecursiveAction;

import java.util.concurrent.ForkJoinPool;

public class recursiveActionMain {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
//        SimpleRecursiveAction simpleRecursiveAction = new SimpleRecursiveAction(20);
//        forkJoinPool.invoke(simpleRecursiveAction);

        SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(200);
        forkJoinPool.invoke(simpleRecursiveAction2);

    }
}
