package com.test.containers;

import com.test.util.Generator;
import com.test.util.RandomGenerator;
import java.util.HashMap;
import java.util.HashSet;

public class TwoStringHashTest {

  public static void main(String[] args) {
    HashSet<ComparableTwoStrings> set = new HashSet<>();
    Generator<ComparableTwoStrings> countingGen = new RandomGenerator.ComparableTwoStrings();
    for (int i = 0; i < 10; i++) {
      set.add(countingGen.next());
    }
    System.out.println("Print HashSet:");
    for (ComparableTwoStrings string : set) {
      System.out.println(string);
    }

    System.out.println("---------------------------------------\nPrint HashMap:");
    HashMap<ComparableTwoStrings, Integer> map = new HashMap<>();
    for (int i = 0; i < 10; i++) {
      map.put(countingGen.next(), i);
    }
    for (ComparableTwoStrings string : map.keySet()) {
      System.out.println(string + ": " +  map.get(string));
    }
  }
}
