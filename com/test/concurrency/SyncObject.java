package com.test.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class DualSynch {
  private Object syncObject = new Object();
  private Object syncObject1 = new Object();
  Lock lock = new ReentrantLock();

  public void f() {
    lock.lock();
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println("f()");
        Thread.yield();
      }
    } finally {
      lock.unlock();
    }
  }

  public void g() {
    lock.lock();
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println("g()");
        Thread.yield();
      }
    } finally {
      lock.unlock();
    }
  }

  public void k() {
    lock.lock();
    try {
      for (int i = 0; i < 5; i++) {
        System.out.println("k()");
        Thread.yield();
      }
    } finally {
      lock.unlock();
    }
  }
}

public class SyncObject {
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
      @Override
      public void run() {
        ds.f();
      }
    }.start();
    ds.g();
    new Thread() {
      @Override
      public void run() {
        ds.k();
      }
    }.start();
  }
}
