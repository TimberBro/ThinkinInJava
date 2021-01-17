package com.test.initialization;

public class UsingThis {
  public void firstMethod() {
    secondMethod();
    this.secondMethod();
  }

  public void secondMethod() {
    System.out.println("This is second method");
  }

  public static void main(String[] args) {
    UsingThis x = new UsingThis();
    x.firstMethod();
  }
}
