package com.test.reusing;

public final class FinalClass {
  static void printMessage() {
    System.out.println("You can't touch this.");
  }
}

/*
class Subclass extends FinalClass {
}

We cannot inherit from final classes.
*/
