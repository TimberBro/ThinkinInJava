package com.test.initialization;

public class Tank {
  int Capacity;
  boolean Empty;

  Tank(int x) {
    if (x > 0) {
      Capacity = x;
      Empty = false;
    } else Empty = true;
  }

  public void spillFuel() {
    Capacity = 0;
    Empty = true;
  }

  protected void finalize() {
    if (!Empty) {
      System.out.println("WARNING! The tank is not empty!");
    }
  }

  public static void main(String[] args) {
    Tank x = new Tank(25);
    System.out.println("Current level of fuel is " + x.Capacity + ". Tank is empty - " + x.Empty);
    System.gc();
    x.spillFuel();
    System.gc();
    // System.out.println("Current level of fuel is " + x.Capacity + ". Tank is empty - " +
    // x.Empty);
    // Tank y = new Tank(1);
    // System.out.println("Current level of fuel is " + y.Capacity + ". Tank is empty - " +
    // y.Empty);
  }
}
