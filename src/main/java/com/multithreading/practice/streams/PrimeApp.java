package com.multithreading.practice.streams;

import java.util.stream.IntStream;

public class PrimeApp {
    public static void main(String[] args) {
        long count = IntStream.rangeClosed(2, Integer.MAX_VALUE / 2).filter(PrimeApp::isPrime).count();
        long countWithParallel = IntStream.rangeClosed(2, Integer.MAX_VALUE / 2).parallel().filter(PrimeApp::isPrime).count();
    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2) return false;
        if (number % 2 == 0) return false;

        long sqrt = (long) Math.sqrt(number);
        for (int i = 3; i < sqrt; i += 2) {
            if (i % 2 == 0) return false;
        }
        return true;
    }
}
