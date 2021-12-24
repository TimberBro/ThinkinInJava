package com.test.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Philosopher implements Runnable {
  private BlockingQueue<Chopstick> queue;
  private final int id;
  private final int ponderFactor;
  private Random rand = new Random(47);

  private void pause() throws InterruptedException {
    if (ponderFactor == 0) {
      return;
    }
    TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor * 250));
  }

  public Philosopher(BlockingQueue<Chopstick> bin, int ident, int ponder) {
    queue = bin;
    id = ident;
    ponderFactor = ponder;
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        System.out.println(this + " " + "thinking");
        pause();
        // Philosopher becomes hungry
        System.out.println(this + " " + "grabbing first");
        Chopstick stick1 = queue.take();
        System.out.println(this + " " + "grabbing second");
        Chopstick stick2 = queue.take();
        System.out.println(this + " " + "eating");
        pause();
        queue.put(stick1);
        queue.put(stick2);
      }
    } catch (InterruptedException e) {
      System.out.println(this + " " + "exiting via interrupt");
    }
  }

  public String toString() {
    return "Philosopher " + id;
  }
}
