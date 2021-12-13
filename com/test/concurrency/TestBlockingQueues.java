package com.test.concurrency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

class LiftOffProducer implements Runnable {

  private LiftOffRunner runner;

  LiftOffProducer(LiftOffRunner runner) {
    this.runner = runner;
  }

  @Override
  public void run() {
    try {
      for (int i = 0; i < 5; i++) {
        runner.add(new LiftOff(10));
      }
    } catch (Exception e) {
      System.out.println("Producer run() interrupted");
      e.printStackTrace();
    }
    System.out.println("End of producing");
  }
}

class LiftOffRunner implements Runnable {

  private BlockingQueue<LiftOff> rockets;

  public LiftOffRunner(BlockingQueue<LiftOff> queue) {
    rockets = queue;
  }

  public void add(LiftOff lo) {
    try {
      rockets.put(lo);
    } catch (InterruptedException e) {
      System.out.println("Interrupted during put()");
    }
  }

  public void run() {
    try {
      while (!Thread.interrupted()) {
        LiftOff rocket = rockets.take();
        rocket.run(); // Use this thread
      }
    } catch (InterruptedException e) {
      System.out.println("Waking from take()");
    }
    System.out.println("Exiting LiftOffRunner");
  }
}

public class TestBlockingQueues {

  static void getkey() {
    try {
      // Compensate for Windows/Linux difference in the
      // length of the result produced by the Enter key:
      new BufferedReader(new InputStreamReader(System.in)).readLine();
    } catch (java.io.IOException e) {
      throw new RuntimeException(e);
    }
  }

  static void getkey(String message) {
    System.out.println(message);
    getkey();
  }

  static void test(String msg, BlockingQueue<LiftOff> queue) {
    System.out.println(msg);
    ExecutorService exec = Executors.newFixedThreadPool(2);
    LiftOffRunner runner = new LiftOffRunner(queue);
    LiftOffProducer producer = new LiftOffProducer(runner);
    exec.execute(runner);
    exec.execute(producer);
    getkey("Press 'Enter' (" + msg + ")");
    exec.shutdownNow();
    System.out.println("Finished " + msg + " test");
  }

  public static void main(String[] args) {
    test("LinkedBlockingQueue", // Unlimited size
        new LinkedBlockingQueue<>());
    test("ArrayBlockingQueue", // Fixed size
        new ArrayBlockingQueue<>(3));
    test("SynchronousQueue", // Size of 1
        new SynchronousQueue<>());
  }
}
