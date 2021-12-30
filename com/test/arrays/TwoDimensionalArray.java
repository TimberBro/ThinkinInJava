package com.test.arrays;

public class TwoDimensionalArray {

  static double[][] fillArray(int length, int width, double startValue, double endValue) {
    double[][] array = new double[length][width];
    double step = (endValue - startValue) / (length * width);
    double initValue = startValue;
    for (int i = 0; i < length; i++) {
      for (int j = 0; j < width; j++) {
        array[i][j] = initValue;
        initValue += step;
      }
    }
    return array;
  }

  static void printArray(double[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.printf("%6.2f ", a[i][j]);
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    printArray(fillArray(2, 3, 30, 60));
    System.out.println();
    printArray(fillArray(1, 15, 2, 583));
    System.out.println();
    printArray(fillArray(15, 15, 2, 583));
  }
}
