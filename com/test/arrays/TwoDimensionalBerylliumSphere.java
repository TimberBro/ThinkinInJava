package com.test.arrays;

import java.util.Arrays;

public class TwoDimensionalBerylliumSphere {

  static BerylliumSphere[][] fillArray(int length, int width) {
    BerylliumSphere[][] array = new BerylliumSphere[length][width];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        array[i][j] = new BerylliumSphere();
      }
    }
    return array;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(fillArray(3,6)));
  }
}
