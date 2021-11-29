package com.test.concurrency;

import java.util.concurrent.TimeUnit;

public class LiftOff implements Runnable {

  // Highly increased to fail all threads
  protected int countDown = 1000000;
  private static int taskCount = 0;
  private final int id = taskCount++;

  public LiftOff() {
    try {
      TimeUnit.MILLISECONDS.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public LiftOff(int countDown) {
    this.countDown = countDown;
  }

  public String status() {
    return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
  }

  public void run() {
    while (countDown-- > 0) {
      if (Thread.currentThread().isInterrupted()) {
        System.out.println("Interrupted: #" + id);
        return;
      }
      System.out.print(status());
      Thread.yield();
    }
  }
}
