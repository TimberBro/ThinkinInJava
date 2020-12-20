package com.test.operators;

public class SignedRightShift {
  public static void main(String[] args) {
    int x = 0x100;
    for (int i = 0; i < 12; i++){
      System.out.println(Integer.toBinaryString(x));
      x >>= 1;
    }
  }
}
