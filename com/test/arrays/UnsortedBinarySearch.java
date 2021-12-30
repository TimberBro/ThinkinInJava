package com.test.arrays;

import com.test.util.ConvertTo;
import com.test.util.Generated;
import com.test.util.Generator;
import com.test.util.RandomGenerator;
import java.util.Arrays;

public class UnsortedBinarySearch {
  public static void main(String[] args) {
    Generator<Integer> gen = new RandomGenerator.Integer(1000);
    int[] a = ConvertTo.primitive(Generated.array(new Integer[25], gen));
    System.out.println("Unexpected behavior: ");
    System.out.println("Array a = " + Arrays.toString(a));
    System.out.println("Binary search of 555 = " + Arrays.binarySearch(a, 555));
    System.out.println("\nExpected behavior: ");
    Arrays.sort(a);
    System.out.println("Sorted array a = " + Arrays.toString(a));
    System.out.println("Binary search of 555 = " + Arrays.binarySearch(a, 555));
  }
}
