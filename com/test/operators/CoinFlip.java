package com.test.operators;

import static com.test.util.Print.print;

import java.util.Random;

public class CoinFlip {
  public static void main(String[] args) {
    Random randomNumberGenerator = new Random();
    if (randomNumberGenerator.nextInt(100) < 50) {
      print("Орел");
    } else {
      print("Решка");
    }
  }
}
