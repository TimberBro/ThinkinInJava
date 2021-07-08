package com.test.exceptions;

class Thrower4 {
  // Now we don't need to specify that method throws an error
  static void f() {
    try {
      g();
    } catch (Exception1 exception1) {
      throw new RuntimeException(exception1);
    }
  }

  static void g() throws Exception1 {
    throw new Exception1();
  }
}

public class Exercise11 {
  public static void main(String[] args) {
    Thrower4.f();
    // And we don't need to use try-catch block
  }
}
