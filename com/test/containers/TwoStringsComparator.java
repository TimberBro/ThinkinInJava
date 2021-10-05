package com.test.containers;

import java.util.Comparator;

public class TwoStringsComparator implements Comparator<ComparableTwoStrings> {

  @Override
  public int compare(ComparableTwoStrings o1, ComparableTwoStrings o2) {
    return o1.getSecondString().toLowerCase().compareTo(o2.getSecondString().toLowerCase());
  }
}
