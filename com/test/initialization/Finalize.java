package com.test.initialization;

public class Finalize {
  protected void finalize() {
    System.out.println("Your object has been finalized");
  }

  public static void main(String[] args) {
    Finalize x = new Finalize();
    x.finalize();
  }
}
