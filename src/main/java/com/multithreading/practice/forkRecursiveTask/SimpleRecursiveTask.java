package com.multithreading.practice.forkRecursiveTask;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {
    private int action;

    public SimpleRecursiveTask(int action) {
        this.action = action;
    }

    @Override
    protected Integer compute() {
        if (action > 100) {
            System.out.println("parallel execution and split tasks ... " + action);
            SimpleRecursiveTask simpleRecursiveTask1 = new SimpleRecursiveTask(action / 2);
            SimpleRecursiveTask simpleRecursiveTask2 = new SimpleRecursiveTask(action / 2);

            simpleRecursiveTask1.fork();
            simpleRecursiveTask2.fork();
            int solution = 0;
            solution += simpleRecursiveTask1.join();
            solution += simpleRecursiveTask2.join();
            return solution;
        } else {
            System.out.println("no need for parallel execution, sequential algorithm is ok... " + action);
            return 2 * action;
        }
    }
}
