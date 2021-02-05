package com.test.reusing;

class Base {
  Base() {
    System.out.println("Base(); ");
  }
}

class Derived1 extends Base {
  Derived1() {
    System.out.println("Derived1(); ");
  }
}

class Derived2 extends Derived1 {
  Derived2() {
    System.out.println("Derived2(); ");
  }
}

public class ConstructionOrder {
  public static void main(String[] args) {
    System.out.println("Create Derived2: ");
    new Derived2();
    System.out.println("Create Derived1: ");
    new Derived1();
    System.out.println("Create Base: ");
    new Base();
  }
}
