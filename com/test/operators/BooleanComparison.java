package com.test.operators;

public class BooleanComparison {

  static void equals(String x, String y) {
    System.out.println(x == y);
    System.out.println(x != y);
    System.out.println(x.equals(y));
    System.out.println(y.equals(x));
  }

  public static void main(String[] args) {
    String x = "HELLO!";
    String y = "hello!";
    equals(x, y);
  }
}
