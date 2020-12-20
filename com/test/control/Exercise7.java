package com.test.control;

public class Exercise7 {
  public static void counter() {
    for (int i = 1; i <= 100; i++) {
      if (i == 100) {
        break;
      }
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    Exercise7.counter();
  }
}
