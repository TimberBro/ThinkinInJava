package com.test.arrays;

import java.util.Arrays;

public class ThreeDimensionalBerylliumSphere {

  static BerylliumSphere[][][] fillArray(int length, int width, int depth) {
    BerylliumSphere[][][] array = new BerylliumSphere[length][width][depth];
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < depth; k++) {
          array[i][j][k] = new BerylliumSphere();
        }
      }
    }
    return array;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.deepToString(fillArray(3, 6, 2)));
  }
}
