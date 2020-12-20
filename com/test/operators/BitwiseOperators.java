package com.test.operators;

import static com.test.util.Print.print;

public class BitwiseOperators {
  public static void main(String[] args) {
    int x = 0x2A;
    int y = 0x55;
    print("x = " + Integer.toBinaryString(x));
    print("y = " + Integer.toBinaryString(y));
    print("x & y = " + Integer.toBinaryString(x & y));
    print("x | y = " + Integer.toBinaryString(x | y));
    print("x ^ y = " + Integer.toBinaryString(x ^ y));
    print("~x = " + Integer.toBinaryString(~x));
    print("~y = " + Integer.toBinaryString(~y));
  }
}
