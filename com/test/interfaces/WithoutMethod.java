package com.test.interfaces;

public abstract class WithoutMethod {}

class Derived extends WithoutMethod {
  public void method() {
    System.out.println("Method");
  }

  static void method2(WithoutMethod x) {
    ((Derived) x).method();
  }

  public static void main(String[] args) {
    Derived derived = new Derived();
    derived.method();
    method2(derived);
  }
}
