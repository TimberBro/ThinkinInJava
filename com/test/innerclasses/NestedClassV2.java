package com.test.innerclasses;

public class NestedClassV2 {
  class Inner1 {
    class Inner2 {
      void f() {
        System.out.println("Inner2.f()");
      }
    }
    Inner2 getInner2() {
      return new Inner2();
    }
  }
  Inner1 getInner1() {
    return new Inner1();
  }

  static class Nested1 {
    void f() {
      System.out.println("Nested1.f()");
    }
    static class Nested2 {
      void f() {
        System.out.println("Nested2.f()");
      }
    }
  }

  public static void main(String[] args) {
    NestedClassV2 outer = new NestedClassV2();
    Inner1 x = outer.getInner1();
    Inner1.Inner2 y = x.getInner2();
    new Nested1().f();
    new Nested1.Nested2().f();
  }
}
