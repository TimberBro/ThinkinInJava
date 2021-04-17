package com.test.reusing;

class A {
  A(int i) {
    System.out.println("This is A constructor " + i);
  }
}

class B {
  B(int i) {
    System.out.println("This is B constructor " + i);
  }
}

public class C extends A {

  B b = new B(15);

  C(int i) {
    super(i);
  }

  public static void main(String[] args) {
    C c = new C(2);
  }
}
