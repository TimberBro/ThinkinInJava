package com.test.initialization;

public class StaticStrings {
  static String test1 = "Init";
  static String test2;

  static {
    test2 = "Static string";
    System.out.println("Test2 initialized");
  }

  static void f() {
    System.out.println("Your fist string was initiated with \"" + test1 + "\"");
    System.out.println("Second string - \"" + test2 + "\"");
  }

  public static void main(String[] args) {
    StaticStrings x = new StaticStrings();
    StaticStrings.f();
  }
}
