package com.test.concurrency;

import com.test.generics.Fibonacci;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultithreadedFibonacci implements Callable<String> {

  private final int id = taskCount++;
  private static int taskCount = 0;
  private int sequenceLength;
  private int sum;
  ExecutorService exec = Executors.newCachedThreadPool();

  public Future<String> runTask(int sequenceLength) {
    this.sequenceLength = sequenceLength;
    return exec.submit(this);
  }

  @Override
  public String call() {
    Fibonacci gen = new Fibonacci();
    for (int i = 0; i < sequenceLength; i++) {
      sum += gen.next();
    }
    return "Sum of first " + sequenceLength + " fibonacci numbers from thread№" + id + " = " + sum;
  }

  // Solution possibly not multithreaded. Not enough information to solve.
  public static void main(String[] args) {
    MultithreadedFibonacci fibonacci = new MultithreadedFibonacci();
    try {
      for (int i = 1; i <= 5; i++) {
        System.out.println(fibonacci.runTask(i).get());
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    } finally {
      fibonacci.exec.shutdown();
    }
  }
}
