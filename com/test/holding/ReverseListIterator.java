package com.test.holding;

import java.util.*;

public class ReverseListIterator {

  static void reverse(List<Integer> listSource, List<Integer> listDest) {
    ListIterator<Integer> sourceIt = listSource.listIterator(listSource.size());
    ListIterator<Integer> destIt = listDest.listIterator();
    while (sourceIt.hasPrevious()) {
      destIt.next();
      destIt.set(sourceIt.previous());
    }
  }


  public static void main(String[] args) {
    List<Integer> listSource = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
    List<Integer> listDest = new LinkedList<Integer>(listSource);
    reverse(listSource, listDest);
    System.out.println(listDest);
  }
}
