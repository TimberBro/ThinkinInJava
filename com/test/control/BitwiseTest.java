package com.test.control;

public class BitwiseTest {
  static void binaryPrint(int x) {
    if (x == 0) {
      System.out.print(0);
    } else {
      int numberOfLeadingZeros = Integer.numberOfLeadingZeros(x);
      x <<= numberOfLeadingZeros;
      for (int p = 0; p < 32 - numberOfLeadingZeros; p++) {
        int n = (Integer.numberOfLeadingZeros(x) == 0) ? 1 : 0;
        System.out.print(n);
        x <<= 1;
      }
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int x = 0x2A;
    int y = 0x55;
    System.out.println("Using Integer.toBinaryString():");
    System.out.println("x = " + Integer.toBinaryString(x));
    System.out.println("y = " + Integer.toBinaryString(y));
    System.out.println("x & y = " + Integer.toBinaryString(x & y));
    System.out.println("x | y = " + Integer.toBinaryString(x | y));
    System.out.println("x ^ y = " + Integer.toBinaryString(x ^ y));
    System.out.println("~x = " + Integer.toBinaryString(~x));
    System.out.println("~y = " + Integer.toBinaryString(~y));
    System.out.println("Using binaryPrint():");
    System.out.print("i = ");
    binaryPrint(x);
    System.out.print("j = ");
    binaryPrint(y);
    System.out.print("x & y  = ");
    binaryPrint(x & y);
    System.out.print("x | y  = ");
    binaryPrint(x | y);
    System.out.print("x ^ y  = ");
    binaryPrint(x ^ y);
    System.out.print("~x = ");
    binaryPrint(~x);
    System.out.print("~y = ");
    binaryPrint(~y);
  }
}
