package com.multithreading.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class ProcessorCallable implements Callable<String> {
    private int id;

    public ProcessorCallable(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(2000);
        return "id: " + id;
    }
}

public class AppWithCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Future<String> submit = executorService.submit(new ProcessorCallable(i + 1));
            list.add(submit);
        }

        for (Future<String> future : list) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        executorService.shutdown();
    }
}
