package com.test.concurrency;

public class InconsistentItem {

  private int anInt = 0;
  private String status = "OK";

  // Added synchronized to be thread-safe
  synchronized void manipulate() {
    status = "";
    Thread.yield();
    ++anInt;
    Thread.yield();
    for (Character c : "Working".toCharArray()) {
      status += c;
      Thread.yield();
    }
    Thread.yield();
    ++anInt;
    Thread.yield();
    status = "OK";
    Thread.yield();
    --anInt;
    Thread.yield();
    anInt++;
  }

  // Added synchronized to be thread-safe
  synchronized void showCurrectState() {
    // System.out.println("Object current state " + this);
    if (!status.equals("OK") && anInt % 2 != 0) {
      throw new IllegalStateException();
    }
  }

  @Override
  public String toString() {
    return "InconsistentItem{" + "aDouble=" + anInt + ", status='" + status + '\'' + '}';
  }
}
