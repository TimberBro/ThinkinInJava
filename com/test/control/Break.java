package com.test.control;

public class Break {
  public static void counter() {
    for (int i = 1; i <= 100; i++) {
      if (i == 100) {
        break; // or return will give same result
      }
      System.out.println(i);
    }
  }

  public static void main(String[] args) {
    Break.counter();
  }
}
