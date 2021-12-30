package com.test.exceptions;

class Exception3 extends Exception {}

class Thrower2 {
  static void f() throws Exception1, Exception2, Exception3 {
    throw new Exception1();
  }
}

public class Exercise9 {
  public static void main(String[] args) {
    try {
      Thrower2.f();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
