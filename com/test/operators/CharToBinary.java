package com.test.operators;

import java.util.function.ToIntFunction;

public class CharToBinary {
  static void printCharToBinary(char c) {
    System.out.println(Integer.toBinaryString(c));
  }

  public static void main(String[] args) {
    char s = 'a';
    for (int i = 0; i < 10; i++) {
      printCharToBinary(s);
      s += 1;
    }
  }
}
