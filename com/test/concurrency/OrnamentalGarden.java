package com.test.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Entrance implements Runnable {
  private static Count count = new Count();
  private static List<Entrance> entrances = new ArrayList<>();
  private int number = 0;
  // Doesn't need synchronization to read:
  private final int id;
  private final CountDownLatch latch;
  private static volatile boolean cancel;

  public Entrance(int id, CountDownLatch latch) {
    this.id = id;
    this.latch = latch;
    // Keep this task in a list. Also prevents
    // garbage collection of dead tasks:
    entrances.add(this);
  }

  public void run() {
    while (!cancel) {
      synchronized (this) {
        ++number;
      }
      System.out.println(this + " Total: " + count.increment());
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("Stopping " + this);
        return;
      }
      latch.countDown();
    }
  }

  public static void cancel() {
    cancel = true;
  }

  public synchronized int getValue() {
    return number;
  }

  public String toString() {
    return "Entrance " + id + ": " + getValue();
  }

  public static int getTotalCount() {
    return count.value();
  }

  public static int sumEntrances() {
    int sum = 0;
    for (Entrance entrance : entrances) {
      sum += entrance.getValue();
    }
    return sum;
  }
}

public class OrnamentalGarden {
  public static void main(String[] args) throws Exception {
    CountDownLatch latch = new CountDownLatch(5);
    ExecutorService exec = Executors.newCachedThreadPool();
    for (int i = 0; i < 5; i++) {
      exec.execute(new Entrance(i, latch));
    }
    // Run for a while, then stop and collect the data:
    TimeUnit.SECONDS.sleep(3);
    Entrance.cancel();
    // Can shutdown gracefully
    exec.shutdown();
    latch.await();
    System.out.println("Total: " + Entrance.getTotalCount());
    System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
  }
}
