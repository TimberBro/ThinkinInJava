package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Exercise11 {

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    InconsistentItem item = new InconsistentItem();
    for (int i = 0; i < 10; i++) {
      executor.execute(new ItemRunner(item));
    }
    executor.shutdown();
  }
}
