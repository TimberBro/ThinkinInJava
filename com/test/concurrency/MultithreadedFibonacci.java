package com.test.concurrency;

import com.test.generics.Fibonacci;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class MultithreadedFibonacci implements Callable<String> {

  private final int id = taskCount++;
  private static int taskCount = 0;
  private int sequenceLength;
  private int sum;
  Thread t;

  public Future<String> runTask(int sequenceLength)
      throws ExecutionException, InterruptedException {
    this.sequenceLength = sequenceLength;
    FutureTask<String> futureTask = new FutureTask<>(this);
    if (t == null) {
      t = new Thread(futureTask);
      t.start();
    }
    return futureTask;
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
      try {
        list.add(new MultithreadedFibonacci().runTask(i));
      } catch (ExecutionException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
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
