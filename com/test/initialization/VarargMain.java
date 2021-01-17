package com.test.initialization;

public class VarargMain {
  public static void main(String... args) {
    for (String x : args) {
      System.out.print(x + " ");
    }
  }
}
