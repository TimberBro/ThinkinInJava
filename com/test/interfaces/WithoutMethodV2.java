package com.test.interfaces;


public abstract class WithoutMethodV2 {
  abstract void Method();
}

class DerivedV2 extends WithoutMethodV2 {
  public void Method() {
    System.out.println("Method");
  }

  static void Method2(WithoutMethodV2 x) {
    x.Method();
  }

  public static void main(String[] args) {
    DerivedV2 derived = new DerivedV2();
    derived.Method();
    Method2(derived);
  }
}

