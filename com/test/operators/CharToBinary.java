package com.test.operators;

public class CharToBinary {
  static void printCharToBinary(char c) {
    System.out.print("Binary form = " + Integer.toBinaryString(c));
    System.out.print(", decimal form =  " + (int)c);
    System.out.println(", character = " + c);
  }

  public static void main(String[] args) {
    char s = 'a';
    for (int i = 0; i < 10; i++) {
      printCharToBinary(s);
      s += 1;
    }
  }
}
