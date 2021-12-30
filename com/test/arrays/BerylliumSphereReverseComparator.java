package com.test.arrays;

import java.util.Comparator;

public class BerylliumSphereReverseComparator implements Comparator<BerylliumSphere> {


  @Override
  public int compare(BerylliumSphere o1, BerylliumSphere o2) {
      return o1.getId() > o2.getId() ? -1 : (o1.getId() == o2.getId() ? 0 : 1);
  }
}
