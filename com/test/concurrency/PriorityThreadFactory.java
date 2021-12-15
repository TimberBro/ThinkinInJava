package com.test.concurrency;

import java.util.concurrent.ThreadFactory;

public class PriorityThreadFactory implements ThreadFactory {
  private final int priority;

  PriorityThreadFactory(int priority) {
    this.priority = priority;
  }

  @Override
  public Thread newThread(Runnable r) {
    Thread thread = new Thread(r);
    thread.setPriority(priority);
    return thread;
  }
}
