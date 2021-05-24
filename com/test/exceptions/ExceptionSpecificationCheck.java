package com.test.exceptions;

class Thrower {

  static void f() {
    // throw new NullString("Exception from f()");
    // Unhandled exception: com.test.exceptions.NullString
  }

  static void k() throws NullString {
    throw new NullString("Exception from g()");
  }
}

public class ExceptionSpecificationCheck {
  public static void main(String[] args) {
    try {
      Thrower.k();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
