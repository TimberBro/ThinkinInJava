package com.test.control;

import java.util.Random;

public class InfiniteGreaterThanSecondGeneratedValue {

  public static void main(String[] args) {
    Random random = new Random();
    int secondGeneratedValue = random.nextInt();
    System.out.println("Values will be classified with value = " + secondGeneratedValue);
    while (true) {
      int x = random.nextInt();
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
