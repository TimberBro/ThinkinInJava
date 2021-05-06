package com.test.holding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

class StarWarsNameGenerator {
  String[] names = {
    "Shmi Skywalker",
    "Anakin Skywalker",
    "Luke Skywalker",
    "Leia Organa",
    "Han Solo",
    "Ben Solo",
    "Count Dooku",
    "Sheev Palpatine",
    "Boba Fett"
    };

  int index = 0;

  String next() {
    String name = names[index];
    index = (index + 1) % names.length;
    return name;
  }
}

public class StarWarsNamesCollectionFiller {

  private static StarWarsNameGenerator generator = new StarWarsNameGenerator();

  static Collection fill(Collection<String> collection) {
    for (int i = 0; i < 10; i++) {
      collection.add(generator.next());
    }
    return collection;
  }

  public static void main(String[] args) {
    System.out.println((fill(new ArrayList<String>())));
    System.out.println((fill(new LinkedList<String>())));
    System.out.println((fill(new HashSet<String>())));
    System.out.println((fill(new LinkedHashSet<String>())));
    System.out.println((fill(new TreeSet<String>())));
  }
}
