package com.test.exceptions;

class Thrower3 {
  static void f() throws Exception2 {
    try {
      g();
    } catch (Exception1 exception1) {
      throw new Exception2();
    }
  }

  static void g() throws Exception1 {
    throw new Exception1();
  }
}

public class Exercise10 {
  public static void main(String[] args) {
    try {
      Thrower3.f();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
