package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MoreBasicThreads {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool(new DaemonFactory());
    for(int i = 0; i < 2; i++) {
      executor.execute(new LiftOff());
    }
    System.out.println("Waiting for LiftOff");
    // Second thread output is interrupted, because main exit.
  }
}
