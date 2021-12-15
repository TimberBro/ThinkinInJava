package com.test.concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Sender implements Runnable {
  private Random rand = new Random(47);
  private BlockingQueue<Character> queue = new LinkedBlockingQueue<>();

  public BlockingQueue<Character> getQueue() {
    return queue;
  }

  public void run() {
    try {
      while (true) {
        for (char c = 'A'; c <= 'z'; c++) {
          queue.put(c);
          TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
        }
      }
    } catch (InterruptedException e) {
      System.out.println(e + " Sender sleep interrupted");
    }
  }
}

class Receiver implements Runnable {
  private BlockingQueue<Character> queue;

  public Receiver(Sender sender) {
    queue = sender.getQueue();
  }

  public void run() {
    try {
      while (true) {
        System.out.print("Read: " + queue.take() + ", ");
      }
    } catch (InterruptedException e) {
      System.out.println(e + " Receiver interrupted");
    }
  }
}

public class PipedIO {
  public static void main(String[] args) throws Exception {
    Sender sender = new Sender();
    Receiver receiver = new Receiver(sender);
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(sender);
    exec.execute(receiver);
    TimeUnit.SECONDS.sleep(4);
    exec.shutdownNow();
  }
}
