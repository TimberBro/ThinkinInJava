package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RadiationCounter {

  public static void main(String[] args) throws Exception {
    ExecutorService exec = Executors.newCachedThreadPool();
    for (int i = 0; i < 5; i++) {
      exec.execute(new Scanner(i));
    }
    // Run for a while, then stop and collect the data:
    TimeUnit.SECONDS.sleep(3);
    Scanner.cancel();
    exec.shutdown();
    if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS)) {
      System.out.println("Some tasks were not terminated!");
    }
    System.out.println("Total: " + Scanner.getTotalCount());
    System.out.println("Sum of pieces: " + Scanner.sumScanners());
  }
}
