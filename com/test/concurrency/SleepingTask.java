package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask implements Runnable {

  long minimalSleepTime = 1L;
  long maximumSleepTime = 10L;
  long sleepingTimeSeconds;

  @Override
  public void run() {
    sleepingTimeSeconds =
        minimalSleepTime + (long) (Math.random() * (maximumSleepTime - minimalSleepTime));
    try {
      TimeUnit.SECONDS.sleep(sleepingTimeSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("Thread was in sleep for: " + sleepingTimeSeconds + " seconds");
    }
  }

  public static void main(String[] args) {
    if (args.length < 1) {
      System.out.println("Not enough arguments.");
      System.out.println("Usage: java SleepingTask numberOfThreads");
    }
    if (args.length == 1) {
      ExecutorService executor = Executors.newCachedThreadPool();
      for (int i = 0; i < Integer.parseInt(args[0]); i++) {
        executor.execute(new SleepingTask());
      }
    } else {
      System.out.println("Too much arguments.");
      System.out.println("Usage: java SleepingTask numberOfThreads");
    }
  }
}
