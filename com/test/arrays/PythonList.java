package com.test.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class PythonList {
  public static void main(String[] args) {
    List<Integer> aList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    System.out.println(aList.getClass().getSimpleName());
    System.out.println(aList.get(4));
    aList.add(6);
    aList.addAll(Arrays.asList(7, 8));
    System.out.println(aList);
    List<Integer> aSlice = aList.subList(2, 4);
    System.out.println(aSlice);

    class MyList<T> extends ArrayList<T> {
      MyList(Collection<? extends T> collection) {
        super(collection);
      }

      MyList(int capacity) {
        super(capacity);
      }

      List<T> getReversed() {
        List<T> reversed = new MyList<T>(size());
        ListIterator<T> iterator = listIterator(size());
        while (iterator.hasPrevious()) {
          reversed.add(iterator.previous());
        }
        return reversed;
      }
    }

    MyList<Integer> list2 = new MyList<>(aList);
    System.out.println(list2.getClass().getSimpleName());
    System.out.println(list2.getReversed());
  }
}
