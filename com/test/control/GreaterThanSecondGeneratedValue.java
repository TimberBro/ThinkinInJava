package com.test.control;

import java.util.Random;

public class GreaterThanSecondGeneratedValue {

  static int[] generateRandomIntValues(int[] storage) {
    Random random = new Random();
    for (int i = 0; i < storage.length; i++) {
      storage[i] = random.nextInt();
    }
    return storage;
  }

  public static void main(String[] args) {
    while (true) {
      Random random = new Random();
      int[] storage = new int[25];
      generateRandomIntValues(storage);
      int secondGeneratedValue = random.nextInt();
      System.out.println("Values will be classified with value = " + secondGeneratedValue);
      for (int x : storage) {
        if (x > secondGeneratedValue) {
          System.out.println(x + " > " + secondGeneratedValue);
        } else if (x < secondGeneratedValue) {
          System.out.println(x + " < " + secondGeneratedValue);
        } else {
          System.out.println(x + " = " + secondGeneratedValue);
        }
      }
    }
  }
}
