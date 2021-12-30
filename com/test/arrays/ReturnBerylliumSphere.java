package com.test.arrays;

import java.util.Arrays;

public class ReturnBerylliumSphere {
  static BerylliumSphere[] getSpheres(int i) {
    BerylliumSphere[] spheres = new BerylliumSphere[i];
    for (int j = 0; j < i; j++) {
      spheres[j] = new BerylliumSphere();
    }
    return spheres;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(getSpheres(7)));
  }
}
