package com.test.holding;

import java.util.*;

public class ListStringFeatures {

  public static void main(String[] args) {
    Random rand = new Random(47);

    List<String> strings = new ArrayList<String>(Arrays.asList("one", "two", "three", "four",
        "five", "six", "seven"));
    System.out.println("1: " + strings);
    String string = "fourteen";
    strings.add(string); // Automatically resizes
    System.out.println("2: " + strings);
    System.out.println("3: " + strings.contains(string));
    strings.remove(string); // Remove by object
    String s = strings.get(2);
    System.out.println("4: " + s + " " + strings.indexOf(s));
    String s1 = "one";
    System.out.println("5: " + strings.indexOf(s1));
    System.out.println("6: " + strings.remove(s1));
    // Must be the exact object:
    System.out.println("7: " + strings.remove(s));
    System.out.println("8: " + strings);
    strings.add(3, "seventeen"); // Insert at an index
    System.out.println("9: " + strings);
    List<String> sub = strings.subList(1, 4);
    System.out.println("subList: " + sub);
    System.out.println("10: " + strings.containsAll(sub));
    Collections.sort(sub); // In-place sort
    System.out.println("sorted subList: " + sub);
    // Order is not important in containsAll():
    System.out.println("ll: " + strings.containsAll(sub));
    Collections.shuffle(sub, rand); // Mix it up
    System.out.println("shuffled subList: " + sub);
    System.out.println("12: " + strings.containsAll(sub));
    List<String> copy = new ArrayList<String>(strings);
    sub = Arrays.asList(strings.get(1), strings.get(4));
    System.out.println("sub: " + sub);
    copy.retainAll(sub);
    System.out.println("13 : " + copy);
    copy = new ArrayList<String>(strings); // Get a fresh copy
    copy.remove(2); // Remove by index
    System.out.println("14: " + copy);
    copy.removeAll(sub); // Only removes exact objects
    System.out.println("15 : " + copy);
    copy.set(1, "eleven"); // Replace an element
    System.out.println("16: " + copy);
    copy.addAll(2, sub); // Insert a list in the middle
    System.out.println("17: " + copy);
    System.out.println("18: " + strings.isEmpty());
    strings.clear(); // Remove all elements
    System.out.println("19: " + strings);
    System.out.println("20: " + strings.isEmpty());
    strings.addAll(Arrays.asList("one", "two", "three", "four"));
    System.out.println("21: " + strings);
    Object[] o = strings.toArray();
    System.out.println("22: " + o[3]);
    String[] st = strings.toArray(new String[0]);
    System.out.println("23: " + st[3]);
  }
}
