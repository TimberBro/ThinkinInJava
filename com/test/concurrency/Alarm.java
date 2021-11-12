package com.test.concurrency;

public class Alarm implements Runnable {
  private static int taskCount = 0;
  private final int id = taskCount++;

  public Alarm() {
    System.out.println("Alarm" + id + " : Created.");
  }

  @Override
  public void run() {
    System.out.println("Alarm" + id + " : First message!");
    Thread.yield();
    System.out.println("Alarm" + id + " : Second message!");
    Thread.yield();
    System.out.println("Alarm" + id + " : Third message!");
    Thread.yield();
    System.out.println("Alarm" + id + " : End of work");
  }

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      new Thread(new Alarm()).start();
    }
  }
}
