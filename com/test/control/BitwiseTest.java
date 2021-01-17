package com.test.control;

public class BitwiseTest {

  static void printBinary(int x) {
    boolean leadingZero = true;
    for (int i = 0; i <= 31; i++) {
      int mask = 0x80000000 >>> i;
      if (!leadingZero) {
        System.out.print(((mask & x) == mask ? '1' : '0'));
      } else if (((mask & x) == mask ? '1' : '0') == '1') {
        System.out.print('1');
        leadingZero = false;
      } else if (i == 31) {
        System.out.print(((mask & x) == mask ? '1' : '0'));
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
    System.out.println();
    System.out.println("Using my toBinaryString():");
    System.out.print("i = ");
    printBinary(x);
    System.out.print("j = ");
    printBinary(y);
    System.out.print("x & y  = ");
    printBinary(x & y);
    System.out.print("x | y  = ");
    printBinary(x | y);
    System.out.print("x ^ y  = ");
    printBinary(x ^ y);
    System.out.print("~x = ");
    printBinary(~x);
    System.out.print("~y = ");
    printBinary(~y);
  }
}
