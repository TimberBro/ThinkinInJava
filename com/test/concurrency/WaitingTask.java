package com.test.concurrency;

public class WaitingTask implements Runnable {

  @Override
  public String toString() {
    return getClass().getSimpleName();
  }

  @Override
  public void run() {
    synchronized (this) {
      try {
        wait();
      } catch (InterruptedException e) {
        System.out.println(this + " sleep interrupted.");
        e.printStackTrace();
      }
      System.out.println(this + " end of work.");
    }
  }
}
