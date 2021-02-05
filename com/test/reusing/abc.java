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

public class abc extends A {
  abc(int i) {
    super(i);
    B x = new B(15);
  }
  // B x = new B();
  public static void main(String[] args) {
    abc c = new abc(2);
  }
}
