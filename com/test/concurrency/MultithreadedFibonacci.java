package com.test.concurrency;

import com.test.generics.Fibonacci;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultithreadedFibonacci implements Runnable {

  private final int id = taskCount++;
  private static int taskCount = 0;
  private int sequenceLength;

  MultithreadedFibonacci(int sequenceLength) {
    this.sequenceLength = sequenceLength;
  }

  @Override
  public void run() {
    LinkedList<Integer> list = new LinkedList<>();
    Fibonacci gen = new Fibonacci();
    for (int i = 0; i < sequenceLength; i++) {
      list.add(gen.next());
    }
    System.out.println("From Thread№" + id + ": " + list);
  }

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    for (int i = 1; i <= 5; i++) {
      executor.execute(new MultithreadedFibonacci(i));
    }
    executor.shutdown();
  }
}
