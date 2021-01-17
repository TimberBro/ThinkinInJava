package com.test.initialization;

public class Tank {
  int capacity;
  boolean empty;

  Tank(int x) {
    if (x > 0) {
      capacity = x;
      empty = false;
    } else {
      empty = true;
    }
  }

  public void spillFuel() {
    capacity = 0;
    empty = true;
  }

  protected void finalize() {
    if (!empty) {
      System.out.println("WARNING! The tank is not empty!");
    } else {
      System.out.println("Empty tank");
    }
  }

  public static void main(String[] args) {
    Tank x = new Tank(25);
    System.out.println("Current level of fuel is " + x.capacity + ". Tank is empty - " + x.empty);
    x.finalize();
    x.spillFuel();
    System.out.println("Current level of fuel is " + x.capacity + ". Tank is empty - " + x.empty);
    x = null;
    System.gc();
  }
}
