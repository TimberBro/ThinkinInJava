package com.test.initialization;

public class Finalize {
  protected void finalize() {
    System.out.println("Finalize was called");
  }

  public static void main(String[] args) {
    Finalize x = new Finalize();
    x = null;
    System.gc();
  }
}
