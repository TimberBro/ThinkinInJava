package com.test.concurrency;

import java.util.concurrent.TimeUnit;

public class NonTask {

  void sleep() {
    try {
      TimeUnit.MINUTES.sleep(10);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
