package com.test.arrays;

public class Autoboxing {
  public static void main(String[] args) {
    // Compiles without error.
    int[] primitiveArray = {1, 2, 3, 4, 5};
    // incompatible types: int[] cannot be converted to java.lang.Integer[]
    // Integer[] x = primitiveArray;
    Integer[] wrapperArray = {1, 2, 3, 4, 5};
    // incompatible types: java.lang.Integer[] cannot be converted to int[]
    // int[] y = wrapperArray;
  }
}
