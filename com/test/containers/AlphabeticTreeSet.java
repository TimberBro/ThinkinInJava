package com.test.containers;

import com.test.util.RandomGenerator;
import java.util.TreeSet;

public class AlphabeticTreeSet {
  public static void main(String[] args) {
    TreeSet<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    RandomGenerator.String random = new RandomGenerator.String();
    for (int i = 0; i < 10; i++) {
      treeSet.add(random.next());
    }
    System.out.println(treeSet);
  }
}
