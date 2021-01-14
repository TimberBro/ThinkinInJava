package com.test.initialization;

public class printFromConstructor {

  printFromConstructor() {
    System.out.println("Message from constructor");
  }

  printFromConstructor(String str) {
    System.out.println("Message from constructor with argument: " + str);
  }

  public static void main(String[] args) {
    printFromConstructor x = new printFromConstructor();
    printFromConstructor y = new printFromConstructor("this is argument");
  }
}
