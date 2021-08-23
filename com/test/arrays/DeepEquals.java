package com.test.arrays;

import java.util.Arrays;

public class DeepEquals {
  public static void main(String[] args) {
    int[][] a1 = {{1, 2}, {3, 4}, {5, 6, 7}};
    int[][] a2 = {{1, 2}, {3, 4}, {5, 6, 7}};
    Integer[][] a3 = {{1, 2}, {3, 4}, {5, 6, 7}};

    System.out.println("Arrays.deepEquals(a1, a2) = " + Arrays.deepEquals(a1, a2));
    System.out.println("Arrays.deepEquals(a1, a3) = " + Arrays.deepEquals(a1, a3));
    System.out.println("Arrays.deepEquals(a2, a3) = " + Arrays.deepEquals(a2, a3));
    // a1 not equal to a3, because a1 holding int, which are primitives and not objects, and a3
    // holding Integers, which are Objects.
    // Autoboxing cannot promote int[] into Integer[]
  }
}
