package com.test.innerclasses;

import com.test.innerclasses.Shop.Cashier;

interface Shop {
  class Cashier {
    private int cash;

    Cashier(int i) {
      this.cash = i;
    }

    void printCash() {
      System.out.println(cash);
    }
  }
}

public class Mall implements Shop {
  public static void main(String[] args) {
    Shop.Cashier cashier = new Shop.Cashier(1000);
    cashier.printCash();
  }
}
