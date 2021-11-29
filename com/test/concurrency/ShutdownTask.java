package com.test.concurrency;

public class ShutdownTask {
  public static void main(String[] args) {
    Thread thread =
        new Thread(new Runnable() {
              @Override
              public void run() {
                new NonTask().sleep();
              }
            });
    thread.start();
    thread.interrupt();
  }
}
