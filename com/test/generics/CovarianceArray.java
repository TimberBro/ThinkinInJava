package com.test.generics;

public class CovarianceArray {

  //
  // java.lang.ArrayStoreException: java.lang.Long
  //
  public static void main(String[] args) {
    Number[] numbers = new Integer[10];
    numbers[0] = 1;
    try {
      numbers[1] = new Double(1.2);
    } catch (Exception e) {
      // java.lang.ArrayStoreException: java.lang.Double
      e.printStackTrace();
    }
    try {
      numbers[2] = new Long(125151);
    } catch (Exception e) {
      // java.lang.ArrayStoreException: java.lang.Long
      e.printStackTrace();
    }
  }
}
