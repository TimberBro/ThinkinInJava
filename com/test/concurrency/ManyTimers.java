package com.test.concurrency;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class ManyTimers {

  public static void main(String[] args) {

    for (int i = 0; i < 40; i++) {
      new Timer()
          .schedule(
              new TimerTask() {
                public void run() {
                  System.out.println(
                      "Hello world! currentTimeMillis = " + System.currentTimeMillis());
                }
              },
              2000);
    }
    try {
      TimeUnit.SECONDS.sleep(5);
      System.exit(0);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
