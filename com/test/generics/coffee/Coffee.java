package com.test.generics.coffee;

import com.test.typeinfo.factory.Factory;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Coffee {
  private static long counter = 0;
  private final long id = counter++;

  public String toString() {
    return getClass().getSimpleName() + " " + id;
  }

  public static List<Factory<? extends Coffee>> coffeeFactories =
      Arrays.asList(
          new Latte.Factory(),
          new Mocha.Factory(),
          new Cappuccino.Factory(),
          new Americano.Factory(),
          new Breve.Factory()
          );

  private static Random rand = new Random(47);

  public static Coffee createRandom() {
    int n = rand.nextInt(coffeeFactories.size());
    return coffeeFactories.get(n).create();
  }
}
