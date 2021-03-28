package com.test.innerclasses;

public class Outer {

  Inner getInner() {
    return new Inner();
  }

  class Inner {
    Inner() {
      System.out.println("Inner constructor.");
    }
  }

  public static void main(String[] args) {
    Outer outer = new Outer();
    Outer.Inner inner = outer.getInner();
  }
}
