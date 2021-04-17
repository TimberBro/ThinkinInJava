package com.test.holding;

import java.util.Collection;
import java.util.HashSet;

public class SimpleCollection {
  public static void main(String[] args) {
    Collection<Integer> c = new HashSet<>();
    // HashSet is implementation of Set interface.
    // From Java 7 you can specify type in brackets only on left side.
    for (int i = 0; i < 10; i++) {
      c.add(i); // Autoboxing
    }
    for (Integer i : c) {
      System.out.print(i + ", ");
    }
  }
}
