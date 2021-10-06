package com.test.containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Unsupported {
  static void test(String msg, List<String> list) {
    System.out.println("--- " + msg + " ---");
    Collection<String> c = list;
    Collection<String> subList = list.subList(1, 8);
    // Copy of the sublist:
    Collection<String> c2 = new ArrayList<String>(subList);

    // The List.set() method modifies the value but
    // doesn't change the size of the data structure:
    try {
      list.set(0, "X");
    } catch (Exception e) {
      System.out.println("List.set(): " + e);
    }

    try {
      list.get(0);
    } catch (Exception e) {
      System.out.println("List.get(): " + e);
    }

    try {
      list.indexOf("A");
    } catch (Exception e) {
      System.out.println("List.indexOf(\"A\"): " + e);
    }

    try {
      list.sort(Comparator.reverseOrder());
    } catch (Exception e) {
      System.out.println("List.sort(Comparator.reverseOrder): " + e);
    }

    try {
      list.listIterator();
    } catch (Exception e) {
      System.out.println("List.listIterator(): " + e);
    }
  }

  public static void main(String[] args) {
    List<String> list = Arrays.asList("A B C D E F G H I J K L".split(" "));
    test("Modifiable Copy", new ArrayList<String>(list));
    test("Arrays.asList()", list);
    test("unmodifiableList()", Collections.unmodifiableList(new ArrayList<String>(list)));
  }
}
