package com.test.containers;

import com.test.util.Generator;
import com.test.util.RandomGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoStringTest {

  public static void main(String[] args) {

    List<ComparableTwoStrings> list = new ArrayList<>();
    Generator<ComparableTwoStrings> countingGen = new RandomGenerator.ComparableTwoStrings();
    for (int i = 0; i < 10; i++) {
      list.add(countingGen.next());
    }
    System.out.println("Unmodified list: " + list);
    Collections.sort(list);
    // Sorting works properly
    System.out.println("Sorted by first string: " + list);
    // Search works properly
    System.out
        .println(Collections.binarySearch(list, new ComparableTwoStrings("HvHqXum", "cXZJoog")));
    Collections.sort(list, new TwoStringsComparator());
    // Sorting with comparator works properly
    System.out.println("Sorted by second string: " + list);
    // Search with comparator works properly
    System.out.println(Collections
        .binarySearch(list, new ComparableTwoStrings("gqiaxxE", "AJJmzMs"),
            new TwoStringsComparator()));
  }
}
