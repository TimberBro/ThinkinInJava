package com.test.util;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets {
  static <T> Set<T> clone(Set<T> set) {
    if (set instanceof EnumSet) {
      return ((EnumSet) set).clone();
    }
    return new HashSet<T>(set);
  }

  public static <T> Set<T> union(Set<T> a, Set<T> b) {
    Set<T> result = clone(a);
    result.addAll(b);
    return result;
  }

  public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
    Set<T> result = clone(a);
    result.retainAll(b);
    return result;
  }
  // Subtract subset from superset:
  public static <T> Set<T> difference(Set<T> superset, Set<T> subset) {
    Set<T> result = clone(superset);
    result.removeAll(subset);
    return result;
  }
  // Reflexive--everything not in the intersection:
  public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    return difference(union(a, b), intersection(a, b));
  }
}
