package com.test.arrays;

public class Exercise8<T> {

  @SuppressWarnings("unchecked")
  T[] array = (T[]) new Object[2]; // Compile warning: unchecked cast

  Exercise8(int size) {
    // Unchecked cast: 'java.lang.Object[]' to 'T[]'
    array = (T[]) new Object[size];
  }

  public static void main(String[] args) {
    String[] stringArray = new String[2];
    // incompatible types: java.lang.Integer cannot be converted to java.lang.String
    // stringArray[0] = new Integer(0); // error: incompatible types
    Object[] objectArray = new Object[3];
    objectArray[0] = new String("hi"); // Can store Strings
    objectArray[1] = new BerylliumSphere(); // Can store different objects
    int x = 2;
    objectArray[2] = x;
    System.out.println("objectArray[2]: " + objectArray[2].getClass());
    // objectArray[0] = 3;
    // Primitives will give Runtime java.lang.ArrayStoreException, but they can be autoboxed.
    objectArray = stringArray;
    System.out.println("objectArray: " + objectArray.getClass());
  }
}
