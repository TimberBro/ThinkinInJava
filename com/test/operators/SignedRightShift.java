package com.test.operators;

public class SignedRightShift {
  public static void main(String[] args) {
    int x = Integer.MIN_VALUE;
    for (int i = 0; i < 32; i++) {
      System.out.println(Integer.toBinaryString(x));
      x >>= 1;
    }
  }
}
