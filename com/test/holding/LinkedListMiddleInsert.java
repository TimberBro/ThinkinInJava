package com.test.holding;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListMiddleInsert {

  static void insert(LinkedList<Integer> list, Integer integer) {
    ListIterator<Integer> iterator = list.listIterator(list.size() / 2);
    iterator.add(integer);
  }

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    for (int i = 1; i <= 10; i++) {
      insert(list, i);
    }
    System.out.println(list);
  }
}
