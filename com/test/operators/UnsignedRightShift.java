package com.test.operators;

public class UnsignedRightShift {
  public static void main(String[] args) {
    int x = Integer.MAX_VALUE;
    System.out.println("Before left shift");
    System.out.println(Integer.toBinaryString(x));
    x <<= 2;
    System.out.println("After left shift");
    System.out.println(Integer.toBinaryString(x));
    System.out.println("Start unsigned right shifting");
    for (int i = 0; i < 32; i++) {
      x >>>= 1;
      System.out.println(Integer.toBinaryString(x));
    }
  }
}
