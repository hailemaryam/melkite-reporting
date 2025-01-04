package com.hmmk.melkite.scheduled;

import java.util.concurrent.*;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            int taskId = i;
            Future<?> future = executor.submit(() -> {
                try {
                    Thread.sleep(1000 * taskId);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
            });
            try {
                // Set max execution time to 2 seconds
                future.get(2, TimeUnit.SECONDS);
                System.out.println("task completed");
            } catch (TimeoutException e) {
                System.err.println("Task timed out");
                future.cancel(true); // Cancel the task
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            } finally {
                executor.shutdown();
            }
        }
        executor.shutdown();
//        try {
//            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
//                executor.shutdownNow();
//                System.out.println("AAA");
//            }
//        } catch (InterruptedException e) {
//            executor.shutdownNow();
//            System.out.println("BBBB");
//        }
    }
}
