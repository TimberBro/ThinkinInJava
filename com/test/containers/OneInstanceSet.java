package com.test.containers;

import com.test.util.Countries;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class OneInstanceSet {
  public static void main(String[] args) {
    Set<String> hashSet = new HashSet<>();
    for (int i = 0; i < 10; i++) {
      hashSet.addAll(Countries.names(10));
    }
    System.out.println(hashSet);

    Set<String> linkedHashSetset = new LinkedHashSet<>();
    for (int i = 0; i < 10; i++) {
      linkedHashSetset.addAll(Countries.names(10));
    }
    System.out.println(linkedHashSetset);

    Set<String> treeSet = new TreeSet<>();
    for (int i = 0; i < 10; i++) {
      treeSet.addAll(Countries.names(10));
    }
    System.out.println(treeSet);

    // Outputs are not same, because set store items in different order.
  }
}
