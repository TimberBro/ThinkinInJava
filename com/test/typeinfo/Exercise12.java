package com.test.typeinfo;

import com.test.generics.coffee.Coffee;
import com.test.generics.coffee.CoffeeGenerator;
import com.test.util.TypeCounter;
import java.util.Iterator;

public class Exercise12 {
  public static void main(String[] args) {
    TypeCounter counter = new TypeCounter(Coffee.class);
    for (Coffee coffee : new CoffeeGenerator(10)) {
      System.out.print(coffee.getClass().getSimpleName() + " ");
      counter.count(coffee);
    }
    System.out.println();
    System.out.println(counter);
  }
}
