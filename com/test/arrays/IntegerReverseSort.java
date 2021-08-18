package com.test.arrays;

import com.test.util.Generated;
import com.test.util.Generator;
import com.test.util.RandomGenerator;
import java.util.Arrays;
import java.util.Collections;

public class IntegerReverseSort {
  public static void main(String[] args) {
    Generator<Integer> gen = new RandomGenerator.Integer(1000);
    Integer[] integers = Generated.array(new Integer[25], gen);
    System.out.println("Unsorted array: " + Arrays.asList(integers));
    Arrays.sort(integers, Collections.reverseOrder());
    System.out.println("Sorted array: " + Arrays.asList(integers));
  }
}
