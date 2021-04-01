package com.test.innerclasses;

public class Outer8 {

  class Inner8 {
    private int i = 1337;

    private void f() {
      System.out.println("Inner.f()");
    }
  }

  void accessInner() {
    Inner8 inner = new Inner8();
    System.out.println(inner.i);
    inner.f();
  }

  public static void main(String[] args) {
    Outer8 outer = new Outer8();
    outer.accessInner();
    // Yes, outer class has access to the private elements of inner class.
  }
}
