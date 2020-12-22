package com.test.control;

import java.util.Random;

public class GreaterThanSecondGeneratedValue {

  static int[] generateRandomIntValues(int[] storage){
    Random random = new Random();
    for (int i = 0; i < storage.length; i++) {
      storage[i] = random.nextInt();
    }
    return storage;
  }

  public static void main(String[] args) {
    int[] storage = new int[25];
    generateRandomIntValues(storage);
    System.out.println("Value of second generated item = " + storage[1]);
    for (int x : storage) {
        if (x > storage[1]) {
        System.out.println(x + " > " + storage[1]);
        } else if (x < storage[1]) {
        System.out.println(x + " < " + storage[1]);
        } else {
        System.out.println(x + " = " + storage[1]);
        }
    }
  }
}
