package com.test.innerclasses;

public class Outer2 {
  private String data;

  Outer2(String s) {
    this.data = s;
  }

  Inner getInner() {
    return new Inner();
  }

  class Inner {
    Inner() {
      System.out.println("Inner constructor.");
    }

    public String toString() {
      return data;
    }
  }

  public static void main(String[] args) {
    Outer2 outer = new Outer2("Access data from inner class.");
    Outer2.Inner inner = outer.getInner();
    System.out.println(inner.toString());
  }
}
