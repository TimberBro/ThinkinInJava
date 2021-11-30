package com.test.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Entrance implements Runnable {
  private static Count count = new Count();
  private static List<Entrance> entrances = new ArrayList<>();
  private int number = 0;
  // Doesn't need synchronization to read:
  private final int id;

  public Entrance(int id) {
    this.id = id;
    // Keep this task in a list. Also prevents
    // garbage collection of dead tasks:
    entrances.add(this);
  }

  public void run() {
    while (true) {
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
    }
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
    ExecutorService exec = Executors.newCachedThreadPool();
    for (int i = 0; i < 5; i++) {
      exec.execute(new Entrance(i));
    }
    // Run for a while, then stop and collect the data:
    TimeUnit.SECONDS.sleep(3);
    exec.shutdownNow();
    if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
      System.out.println("Some tasks were not terminated!");
    }
    System.out.println("Total: " + Entrance.getTotalCount());
    System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
  }
}
