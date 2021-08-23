package com.test.arrays;

public class ThreeDimensionalArray {

  static double[][][] fillArray(
      int length, int width, int depth, double startValue, double endValue) {
    double[][][] array = new double[length][width][depth];
    double step = (endValue - startValue) / (length * width * depth);
    double initValue = startValue;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        for (int k = 0; k < depth; k++) {
          array[i][j][k] = initValue;
          initValue += step;
        }
      }
    }
    return array;
  }

  static void printArray(double[][][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        for (int k = 0; k < a[i][j].length; k++) {
          System.out.printf("%6.2f ", a[i][j][k]);
        }
        System.out.println();
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    printArray(fillArray(2, 3, 3, 30, 60));
    System.out.println();
    printArray(fillArray(1, 15, 2, 2, 583));
    System.out.println();
    printArray(fillArray(2, 15, 7, 2, 583));
  }
}
