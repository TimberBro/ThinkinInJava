package com.test.initialization;

public class OverloadedConstructor {
  char symbol;

  OverloadedConstructor() {
    this('w');
    System.out.println("This is constructor without arguments.");
  }

  OverloadedConstructor(char x) {
    symbol = x;
    System.out.println("This is constructor with char argument. Char is " + symbol);
  }

  public static void main(String[] args) {
    OverloadedConstructor b = new OverloadedConstructor();
  }
}
