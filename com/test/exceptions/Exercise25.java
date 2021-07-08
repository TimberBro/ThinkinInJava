package com.test.exceptions;

class ExceptionA extends Exception {}

class ExceptionB extends ExceptionA {}

class ExceptionC extends ExceptionB {}

class A {
  void f() throws ExceptionA {
    throw new ExceptionA();
  }
}

class B extends A {
  @Override
  void f() throws ExceptionB {
    throw new ExceptionB();
  }
}

class C extends B {
  @Override
  void f() throws ExceptionC {
    throw new ExceptionC();
  }
}

public class Exercise25 {
  public static void main(String[] args) {
    A a = new C();
    try {
      a.f();
    } catch (ExceptionA exceptionA) {
      exceptionA.printStackTrace();
    } // Compiler says Unhandled exception: com.test.exceptions.ExceptionA
  }
}
