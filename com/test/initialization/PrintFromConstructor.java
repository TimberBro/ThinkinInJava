package com.test.initialization;

public class PrintFromConstructor {

  PrintFromConstructor() {
    System.out.println("Message from constructor");
  }

  public static void main(String[] args) {
    new PrintFromConstructor();
  }
}
