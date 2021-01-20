package com.test.initialization;

public class Tank {
  static int counter;
  int capacity;
  int id = counter++;
  boolean empty;

  Tank(int x) {
    if (x > 0) {
      capacity = x;
      empty = false;
      System.out.println("Filled tank with id = " + id + " was created. Current capacity = " + capacity + ".");
    } else {
      System.out.println("Empty tank with id = " + id + " was created.");
      empty = true;
    }
  }

  public void spillFuel() {
    capacity = 0;
    empty = true;
  }

  protected void finalize() {
    if (!empty) {
      System.out.println("WARNING! The tank " + id + " is not empty!");
    } else {
      System.out.println("Tank " + id + " is cleaned up");
    }
  }

  public static void main(String[] args) {
    new Tank(0);
    new Tank(15);
    new Tank(25).spillFuel();
    System.gc();
  }
}
