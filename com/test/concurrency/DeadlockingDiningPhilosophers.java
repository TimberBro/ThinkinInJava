package com.test.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class DeadlockingDiningPhilosophers {
  // Taking chopsticks from bin does not prevent deadlock.
  public static void main(String[] args) throws Exception {
    int ponder = 5;
    if (args.length > 0) {
      ponder = Integer.parseInt(args[0]);
    }
    int size = 5;
    if (args.length > 1) {
      size = Integer.parseInt(args[1]);
    }
    ExecutorService exec = Executors.newCachedThreadPool();
    BlockingQueue<Chopstick> sticks = new LinkedBlockingQueue<>();
    // Adding at lease one chopstick will prevent deadlock.
    for (int i = 0; i < size; i++) {
      sticks.put(new Chopstick());
    }
    for (int i = 0; i < size; i++) {
      exec.execute(new Philosopher(sticks, i, ponder));
    }
    if (args.length == 3 && args[2].equals("timeout")) {
      TimeUnit.SECONDS.sleep(5);
    } else {
      System.out.println("Press 'Enter' to quit");
      System.in.read();
    }
    exec.shutdownNow();
  }
}
