package com.test.concurrency;

import com.test.generics.Fibonacci;
import java.util.ArrayList;
import java.util.LinkedList;
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

  MultithreadedFibonacci(int sequenceLength) {
    this.sequenceLength = sequenceLength;
  }

  @Override
  public String call() {
    Fibonacci gen = new Fibonacci();
    for (int i = 0; i < sequenceLength; i++) {
      sum += gen.next();
    }
    return "Sum of first " + sequenceLength + " fibonacci numbers from thread№" + id + " = " + sum;
  }

  public static void main(String[] args) {
    ExecutorService executor = Executors.newCachedThreadPool();
    ArrayList<Future<String>> list = new ArrayList<>();
    for (int i = 1; i <= 5; i++) {
      list.add(executor.submit(new MultithreadedFibonacci(i)));
    }
    for (Future<String> string : list) {
      try {
        System.out.println(string.get());
      } catch (InterruptedException e) {
        System.out.println(e);
        return;
      } catch (ExecutionException e) {
        System.out.println(e);
      } finally {
        executor.shutdown();
      }
    }
  }
}
