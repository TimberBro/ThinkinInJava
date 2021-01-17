package com.test.initialization;

public class OverloadedConstructor {
  char Symbol;

  OverloadedConstructor() {
    this('w');
    System.out.println("This is constructor without arguments.");
  }

  OverloadedConstructor(char x) {
    Symbol = x;
    System.out.println("This is constructor with char argument. Char is " + Symbol);
  }

  public static void main(String[] args) {
    OverloadedConstructor b = new OverloadedConstructor();
  }
}
