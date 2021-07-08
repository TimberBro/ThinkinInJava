package com.test.exceptions;

public class Exercise13 {

  static void throwNPE() {
    throw new NullPointerException();
  }

  public static void main(String[] args) {
    try {
      Thrower2.f();
    } catch (Exception e) {
      System.err.println("Caught " + e);
    } finally {
      System.err.println("End of first clause");
    }
    try {
      throwNPE();
      Thrower2.f();
    } catch (Exception2 | Exception1 | Exception3 e) {
      System.err.println("Caught " + e);
    } finally {
      System.err.println("End of second clause");
    }
  }
}
