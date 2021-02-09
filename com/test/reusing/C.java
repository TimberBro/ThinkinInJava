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


  C(int i) {
    super(i);
    B b = new B(15);
  }

  public static void main(String[] args) {
    C c = new C(2);
  }
}
