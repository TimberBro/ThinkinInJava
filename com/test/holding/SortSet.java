package com.test.holding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SortSet {

  static Set<String> sort(Set<String> unsortedSet) {
    String[] values = unsortedSet.toArray(new String[0]);
    Arrays.sort(values);
    return new LinkedHashSet<>(Arrays.asList(values));
  }

  public static void main(String[] args) {
    Set<String> set = new HashSet<>();
    set.addAll(Arrays.asList("Bob", "Jack", "Alex", "Jean", "Rose", "Jenny"));
    System.out.println("HashSet:");
    System.out.println(set);
    System.out.println("Sorted LinkedHashSet:");
    System.out.println(sort(set));
  }
}
