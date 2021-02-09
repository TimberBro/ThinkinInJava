package com.test.reusing;

class A {
  A() {
    System.out.println("This is A constructor ");
  }
}

class B {
  B() {
    System.out.println("This is B constructor ");
  }
}

public class C extends A {

  B b = new B();

  public static void main(String[] args) {
    C c = new C();
  }
}
