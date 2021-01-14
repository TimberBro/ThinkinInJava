package com.test.control;

public class BitwiseTest {

  static char[] getBinary(int x) {
    char[] buffer = new char[32];
    int position = 32;
    for (int i = 31; i >= 0; i--) {
      int mask = 0x80000000 >>> i;
      buffer[--position] = (((mask & x) == mask ? '1' : '0'));
    }
    return buffer;
  }

  static void toBinaryString(int x) {
    char[] buffer = getBinary(x);
    int i = 0;
    while (buffer[i] != '1' & i < 31) {
      i++;
    }
    for (int j = i; j < 32; j++) {
      System.out.print(buffer[j]);
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
    toBinaryString(x);
    System.out.print("j = ");
    toBinaryString(y);
    System.out.print("x & y  = ");
    toBinaryString(x & y);
    System.out.print("x | y  = ");
    toBinaryString(x | y);
    System.out.print("x ^ y  = ");
    toBinaryString(x ^ y);
    System.out.print("~x = ");
    toBinaryString(~x);
    System.out.print("~y = ");
    toBinaryString(~y);
  }
}
