package com.test.generics;

import com.test.util.Generator;

public class BigFish {
  private static long counter = 1;
  private final long id = counter++;

  private BigFish() {}

  public String toString() {
    return "BigFish " + id;
  }

  public static Generator<BigFish> generator =
      new Generator<BigFish>() {
        public BigFish next() {
          return new BigFish();
        }
      };
}
