package com.test.exceptions;

public class OutOfBound {
  public static void main(String[] args) {
    int[] ints = new int[5];
    try {
      for (int i = 0; i < 6; i++) {
        ints[i] = i;
      }
    } catch (IndexOutOfBoundsException e) {
      throw new RuntimeException(e);
    }
  }
}
