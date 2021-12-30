package com.test.typeinfo;

import com.test.typeinfo.factory.*;
import com.test.util.TypeCounter;

public class Exercise13 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Part.class);
    Part part;
    for (int i = 0; i < 10; i++) {
      part = Part.createRandom();
      System.out.print(part.getClass().getSimpleName() + " ");
      counter.count(part);
    }
    System.out.println();
    System.out.println(counter);
  }
}
