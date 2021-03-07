package com.test.polymorphism;

public class Shared {

  private static long counter = 0;
  private final long id = counter++;
  private int refcount = 0;

  public Shared() {
    System.out.println("Creating " + this);
  }

  public void addRef() {
    refcount++;
  }

  protected void dispose() {
    if (--refcount == 0) System.out.println("Disposing " + this);
  }

  public String toString() {
    return "Shared " + id;
  }

  public void showRefcount() {
    System.out.println("Refcount = " + refcount);
  }

  protected void finalize() {
    if (refcount > 0) {
      System.out.println("Error: Shared with id = " + id + " is in use.");
    } else {
      System.out.println("The Shared object cleaned up.");
    }
  }
}
