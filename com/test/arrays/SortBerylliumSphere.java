package com.test.arrays;

import com.test.util.Generated;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SortBerylliumSphere {

  public static void main(String[] args) {
    Random random = new Random(47);
    BerylliumSphere[] spheres =
        Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator<>(), 15);

    Collections.shuffle(Arrays.asList(spheres), random);
    System.out.println("Before sort: " + Arrays.toString(spheres));
    // java.lang.ClassCastException: com.test.arrays.BerylliumSphere cannot be cast to
    // java.lang.Comparable

    Arrays.sort(spheres);
    System.out.println("After sort: " + Arrays.toString(spheres));
    // Can solve this problem without my own comparator using Collections.reverseOrder()

    Arrays.sort(spheres, new BerylliumSphereReverseComparator());
    System.out.println("After reverse sort: " + Arrays.toString(spheres));
  }
}
