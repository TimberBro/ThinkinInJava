package com.test.control;

public class Break {
  public static void counter() {
    for (int i = 1; i <= 100; i++) {
      System.out.println(i);
      if (i == 99) {
        break; // or return will give same result
      }
    }
  }

  public static void main(String[] args) {
    Break.counter();
  }
}
