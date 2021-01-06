package com.test.initialization;

class Strings {
  static String test1;
  static String test2;

  Strings(String x) {
    test1 = x;

    System.out.println("Test1 initialized");
  }

  static {
    test2 = "Isn't constructor definition";
    System.out.println("Test2 initialized");
  }

  static void f() {
    System.out.println(test2);
    System.out.println("Your string was initiated with \"" + test1 + "\"");
  }
}

public class Exercise14 {
  public static void main(String[] args) {
    Strings x = new Strings("This");
    Strings.f();
  }
}
