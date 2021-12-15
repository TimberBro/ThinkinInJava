package com.test.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WaitingTaskTest {

  public static void main(String[] args) {
    Runnable task1 = new WaitingTask();
    Runnable task2 = new WaitingTask2(task1);
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(task1);
    exec.execute(task2);
    exec.shutdown();
  }

}
