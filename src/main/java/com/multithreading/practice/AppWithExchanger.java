package com.multithreading.practice;

import java.util.concurrent.Exchanger;
// use cases: in generic algorithms , training neutral networks
class FirstExchanger implements Runnable {
    private Exchanger<Integer> exchanger;
    private int firstCounter;

    public FirstExchanger(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            firstCounter++;
            System.out.println("first worker increments the counter: " + firstCounter);
            try {
                firstCounter = exchanger.exchange(firstCounter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


class SecondExchanger implements Runnable {
    private Exchanger<Integer> exchanger;
    private int secondCounter;

    public SecondExchanger(Exchanger<Integer> exchanger) {
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        while (true) {
            secondCounter--;
            System.out.println("second worker decrements the counter: " + secondCounter);
            try {
                secondCounter = exchanger.exchange(secondCounter);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class AppWithExchanger {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<>();
        new Thread(new FirstExchanger(exchanger)).start();
        new Thread(new SecondExchanger(exchanger)).start();
    }
}
