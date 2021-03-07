package com.test.polymorphism;

class Shared {
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
    if (--refcount == 0)
      System.out.println("Disposing " + this);
  }

  public String toString() {
    return "Shared " + id;
  }

  protected void finalize() {
    if (refcount > 0) {
      System.out.println("Error: Shared with id = " + id + " is in use.");
    }
    else {
      System.out.println("The Shared object cleaned up.");
    }
  }
}

class Composing {
  private static long counter = 0;
  private final Shared shared;
  private final long id = counter++;

  public Composing(Shared shared) {
    System.out.println("Creating " + this);
    this.shared = shared;
    this.shared.addRef();
  }

  protected void dispose() {
    System.out.println("Disposing " + this);
    shared.dispose();
  }

  public String toString() {
    return "Composing " + id;
  }
}

public class ReferenceCounting {
  public static void main(String[] args) {
    Shared shared = new Shared();
    Composing[] composing = {
      new Composing(shared),
      new Composing(shared),
      new Composing(shared),
      new Composing(shared),
      new Composing(shared)
    };
    for (Composing c : composing) c.dispose();
    new Composing(new Shared()); // This will give us an error, because Shared
    // object used by composing object
    System.gc();
    new Composing(new Shared()).dispose(); // This will give us proper cleanup.
    System.gc();
  }
}
