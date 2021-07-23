package com.test.generics;

public class Exercise20 {
  static <T extends Ship> void f(T object) {
    object.dropAnchor();
    object.raiseAnchor();
  }

  public static void main(String[] args) {
    f(new Sloop());
  }
}
