package com.test.innerclasses;

public class NestedClass {
  static class Test {
    void f() {
      System.out.println("f()");
    }
  }

  public static void main(String[] args) {
    Test test = new Test();
    test.f();
  }
}
