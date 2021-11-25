package com.test.concurrency;

class DualSynch {
  private Object syncObject = new Object();
  private Object syncObject1 = new Object();

  public synchronized void f() {
    for (int i = 0; i < 5; i++) {
      System.out.println("f()");
      Thread.yield();
    }
  }

  public void g() {
    // Should be synchronized using this keyword
    synchronized (syncObject) {
      for (int i = 0; i < 5; i++) {
        System.out.println("g()");
        Thread.yield();
      }
    }
  }

  public void k() {
    // Should be synchronized using this keyword
    synchronized (syncObject1) {
      for (int i = 0; i < 5; i++) {
        System.out.println("k()");
        Thread.yield();
      }
    }
  }
}

public class SyncObject {
  public static void main(String[] args) {
    final DualSynch ds = new DualSynch();
    new Thread() {
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
