package com.test.initialization;

public class Exercise19 {
  static void f(String... args) {
    for (String x : args) {
      System.out.println(x);
    }
  }

  public static void main(String[] args) {
    Exercise19.f("Test", "Test2", "test");
    String[] a = {
      "q", "w", "e",
    };
    Exercise19.f(a);
  }
}
