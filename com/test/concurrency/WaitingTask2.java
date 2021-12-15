package com.test.concurrency;

import java.util.concurrent.TimeUnit;

public class WaitingTask2 implements Runnable {
  Runnable firstTaskReference;

  WaitingTask2(Runnable firstTask) {
    firstTaskReference = firstTask;
  }

  @Override
  public void run() {
    try {
      TimeUnit.SECONDS.sleep(5);
      // Without this synchronized block you'll get IllegalMonitorStateException
      synchronized (firstTaskReference) {
        firstTaskReference.notifyAll();
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
