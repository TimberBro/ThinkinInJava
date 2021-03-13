package com.test.interfaces;

public abstract class WithoutMethod {

}

class Derived extends WithoutMethod {
  public void Method() {
    System.out.println("Method");
  }

  static void Method2(WithoutMethod x) {
    ((Derived)x).Method();
  }

  public static void main(String[] args) {
    Derived derived = new Derived();
    derived.Method();
    Method2(derived);
  }
}
