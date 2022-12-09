package com.multithreading.practice;

import java.util.Comparator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

class FirstPriorityWorker implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public FirstPriorityWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put("d");
            blockingQueue.put("c");
            blockingQueue.put("a");
            blockingQueue.put("f");
            blockingQueue.put("b");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class SecondPriorityWorker implements Runnable {
    private BlockingQueue<String> blockingQueue;

    public SecondPriorityWorker(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}


class ThirdPriorityWorker implements Runnable {
    private BlockingQueue<Person> blockingQueue;

    public ThirdPriorityWorker(BlockingQueue<Person> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            blockingQueue.put(new Person("Omid",20));
            blockingQueue.put(new Person("Jack",23));
            blockingQueue.put(new Person("Reza",12));
            blockingQueue.put(new Person("Joe",15));
            blockingQueue.put(new Person("Mark",32));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class FourthPriorityWorker implements Runnable {
    private BlockingQueue<Person> blockingQueue;

    public FourthPriorityWorker(BlockingQueue<Person> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        try {
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
            System.out.println(blockingQueue.take());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public String toString(){
        return name;
    }
}

public class AppWithPriorityQueue {
    public static void main(String[] args) {
//        BlockingQueue<String> queue = new PriorityBlockingQueue<>();
//
//
//        FirstPriorityWorker firstPriorityWorker = new FirstPriorityWorker(queue);
//        SecondPriorityWorker secondPriorityWorker = new SecondPriorityWorker(queue);


        BlockingQueue<Person> people = new PriorityBlockingQueue<>();
        ThirdPriorityWorker thirdPriorityWorker = new ThirdPriorityWorker(people);
        FourthPriorityWorker fourthPriorityWorker = new FourthPriorityWorker(people);

//        new Thread(firstPriorityWorker).start();
//        new Thread(secondPriorityWorker).start();
        new Thread(thirdPriorityWorker).start();
        new Thread(fourthPriorityWorker).start();
    }
}
