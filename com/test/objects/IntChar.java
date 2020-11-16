package com.test.objects;

public class IntChar {

  int number;
  char character;

  public static void main(String[] args) {
    IntChar x = new IntChar();
    System.out.println("Here's yours Number = " + x.number);
    System.out.println("Here's yours Character = " + Integer.toBinaryString(x.character));
  }
}
