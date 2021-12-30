package com.test.arrays;

import com.test.util.Generated;
import java.util.Arrays;

public class BerylliumSphereCopy {
  public static void main(String[] args) {
    BerylliumSphere[] a =
        Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator<BerylliumSphere>(), 5);
    BerylliumSphere[] b = a;
    // Arrays store same things
    System.out.println(Arrays.hashCode(a) == Arrays.hashCode(b));
    a = Generated.array(BerylliumSphere.class, new BerylliumSphereGenerator<BerylliumSphere>(), 6);
    // Now they store different things.
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    System.out.println(Arrays.hashCode(a) == Arrays.hashCode(b));
  }
}
