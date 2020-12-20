package com.test.operators;

public class CharToBinary {
  static void printCharToBinary(char c) {
    System.out.println(Integer.toBinaryString(c));
  }

  public static void main(String[] args) {
    char s = 'a';
    printCharToBinary(s);
  }
}
