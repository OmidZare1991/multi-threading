package com.multithreading.practice.forkRecursiveAction;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {
    int action;

    public SimpleRecursiveAction(int action) {
        this.action = action;
    }

    @Override
    protected void compute() {
        if (action > 100) {
            System.out.println("paralell execution adn split tasks ... " + action);
            SimpleRecursiveAction simpleRecursiveAction1 = new SimpleRecursiveAction(action / 2);
            SimpleRecursiveAction simpleRecursiveAction2 = new SimpleRecursiveAction(action / 2);
            simpleRecursiveAction1.fork();
            simpleRecursiveAction2.fork();
        } else {
            System.out.println("no need for parallel execution, sequential algorithm is ok... " + action);
        }
    }
}
