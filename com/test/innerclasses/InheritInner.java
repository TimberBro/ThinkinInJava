package com.test.innerclasses;

class WithInner {
  class Inner {
    private String name;

    Inner(String s) {
      s = name;
    }
  }
}

public class InheritInner extends WithInner.Inner {

  InheritInner(WithInner wi, String s) {
    wi.super(s);
    System.out.println(s);
  }

  public static void main(String[] args) {
    WithInner wi = new WithInner();
    InheritInner ii = new InheritInner(wi, "Hello, World!");
  }
}
