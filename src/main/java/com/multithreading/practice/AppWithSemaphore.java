package com.multithreading.practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class AppWithSemaphore {
    enum Downloader {
        INSTANCE;
        private Semaphore semaphore = new Semaphore(3, true);

        public void downlaod() {
            try {
                semaphore.acquire();
                downloadData();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                semaphore.release();
            }
        }

        private void downloadData() {
            System.out.println("downloading data ...");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                Downloader.INSTANCE.downlaod();
            });
        }
    }
}
