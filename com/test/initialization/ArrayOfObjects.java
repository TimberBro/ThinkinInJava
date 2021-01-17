package com.test.initialization;

public class ArrayOfObjects {

  ArrayOfObjects(String x) {
    System.out.println("This is your argument: " + x);
  }

  public static void main(String[] args) {
    System.out.println("Inside main");
    ArrayOfObjects[] array = new ArrayOfObjects[7];
    for (int i = 0; i < array.length; i++) {
      array[i] = new ArrayOfObjects(Integer.toString(i));
    }
  }
}
