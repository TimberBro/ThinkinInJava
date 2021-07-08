package com.test.generics;

public class GenericMethods {
  public <T, U, V> void f(T x, U y, V z) {
    System.out.println(x.getClass().getName());
    System.out.println(y.getClass().getName());
    System.out.println(z.getClass().getName());
  }

  public static void main(String[] args) {
    GenericMethods gm = new GenericMethods();
    gm.f("", 1, 1.0);
    gm.f(1.0F, 'c', gm);
  }
}
