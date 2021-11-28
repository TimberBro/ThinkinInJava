package com.test.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Scanner implements Runnable {

  private static Count count = new Count();
  private static List<Scanner> scanners = new ArrayList<Scanner>();
  private int number = 0;
  // Doesn't need synchronization to read:
  private final int id;
  private static volatile boolean canceled = false;

  // Atomic operation on a volatile field:
  public static void cancel() {
    canceled = true;
  }

  public Scanner(int id) {
    this.id = id;
    // Keep this task in a list. Also prevents
    // garbage collection of dead tasks:
    scanners.add(this);
  }

  public void run() {
    while (!canceled) {
      synchronized (this) {
        ++number;
      }
      System.out.println(this + " Total: " + count.increment());
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        System.out.println("sleep interrupted");
      }
    }
    System.out.println("Stopping " + this);
  }

  public synchronized int getValue() {
    return number;
  }

  public String toString() {
    return "Scanner " + id + ": " + getValue();
  }

  public static int getTotalCount() {
    return count.value();
  }

  public static int sumScanners() {
    int sum = 0;
    for (Scanner scanner : scanners) {
      sum += scanner.getValue();
    }
    return sum;
  }
}
