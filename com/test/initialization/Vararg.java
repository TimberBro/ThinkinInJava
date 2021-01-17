package com.test.initialization;

public class Vararg {
  static void f(String... args) {
    for (String x : args) {
      System.out.print(x + " ");
    }
  }

  public static void main(String[] args) {
    Vararg.f("Test", "Test2", "test");
    System.out.println();
    String[] a = {"q", "w", "e", "r", "t"};
    Vararg.f(a);
  }
}
