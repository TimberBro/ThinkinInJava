package com.test.concurrency;

import java.util.concurrent.TimeUnit;

class Daemon implements Runnable {

  private Thread[] t = new Thread[10];

  public void run() {
    for (int i = 0; i < t.length; i++) {
      t[i] = new Thread(new DaemonSpawn());
      t[i].start();
      System.out.print("DaemonSpawn " + i + " started, ");
    }
    for (int i = 0; i < t.length; i++) {
      try {
        TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        System.out.print("Finally: " + t[i].getName() + "; ");
      }
      System.out.print("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
    }
    while (true) {
      Thread.yield();
    }
  }
}

class DaemonSpawn implements Runnable {

  public void run() {
    while (true) {
      Thread.yield();
    }
  }
}

public class Daemons {
  /*
  Daemon thread will be terminated after main thread will finish it work.
  Finally clauses of daemon thread may not be executed, because thread terminated abruptly.
   */
  public static void main(String[] args) throws Exception {
    Thread d = new Thread(new Daemon());
    d.setDaemon(true);
    d.start();
    System.out.print("d.isDaemon() = " + d.isDaemon() + ", ");
    // Allow the daemon threads to
    // finish their startup processes:
    TimeUnit.MILLISECONDS.sleep(400);
  }
}
