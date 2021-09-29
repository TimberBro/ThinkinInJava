package com.test.containers;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

  private int[] array;
  int index;

  public MyArrayList(int initialCapacity) {
    array = new int[initialCapacity];
  }

  public void add(int s) {
    if (index == array.length) {
      int[] tmp = new int[array.length + 1];
      for (int i = 0; i < array.length; i++) {
        tmp[i] = array[i];
      }
      //index = array.length;
      array = tmp;
    }
    array[index++] = s;
  }

  public int get(int i) {
    return array[i];
  }

  public void set(int i, int val) {
    array[i] = val;
  }

  public int size() {
    return index;
  }

  static List<Test<List<Integer>>> arrayListTests = new ArrayList<>();
  static List<Test<MyArrayList>> myArrayListTests = new ArrayList<>();
  static final int LOOPS = 10000;

  static {
    arrayListTests.add(new Test<List<Integer>>("al") {
      int test(List<Integer> list, TestParam tp) {
        for (int i = 0; i < LOOPS; i++) {
          list.add(i);
          list.set(i, list.get(i) + 1);
          list.get(i);
        }
        return LOOPS;
      }
    });
    myArrayListTests.add(new Test<MyArrayList>("mal") {
      int test(MyArrayList list, TestParam tp) {
        for (int i = 0; i < LOOPS; i++) {
          list.add(i);
          list.set(i, list.get(i) + 1);
          list.get(i);
        }
        return LOOPS;
      }
    });
  }

  public static void main(String[] args) {
    Tester.defaultParams = TestParam.array(LOOPS, 1);
    Tester.run(new ArrayList<>(LOOPS), arrayListTests);
    Tester.run(new MyArrayList(LOOPS), myArrayListTests);
  }
}
