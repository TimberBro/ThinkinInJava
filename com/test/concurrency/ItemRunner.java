package com.test.concurrency;

import java.util.Random;

public class ItemRunner implements Runnable {

  private static Random random = new Random();
  private InconsistentItem item;

  @Override
  public void run() {
    while (true) {
      item.manipulate();
      item.showCurrectState();
    }
  }

  ItemRunner(InconsistentItem item) {
    this.item = item;
  }
}
