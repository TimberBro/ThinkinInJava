package com.test.interfaces;

public abstract class WithoutMethodV2 {
  abstract void method();
}

class DerivedV2 extends WithoutMethodV2 {
  public void method() {
    System.out.println("Method");
  }

  static void method2(WithoutMethodV2 x) {
    x.method();
  }

  public static void main(String[] args) {
    DerivedV2 derived = new DerivedV2();
    derived.method();
    method2(derived);
  }
}
