package com.test.arrays;

import java.util.ArrayList;
import java.util.List;

public class ArrayOfGenerics {
  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    ArrayList<List<String>> ls = new ArrayList<>();
    ls.add(new ArrayList<String>());
    // Compile-time checking produces an error:
    // ls.add(new ArrayList<Integer>());
    // I replaced arrays with containers, but I don't understand which compile-time warnings I
    // had to eliminate by this exercise.
  }
}
