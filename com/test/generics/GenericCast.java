package com.test.generics;

import java.util.ArrayList;
import java.util.List;

class FixedSizeStack<T> {
  private int index = 0;
  private int size;
  private List<T> storage;

  public FixedSizeStack(int size) {
    storage = new ArrayList<T>(size);
    this.size = size;
  }

  public void push(T item) {
    if (index < size) {
      index++;
      storage.add(item);
    } else {
      throw new RuntimeException("Cannot add item: \"" + item + "\". The stack is full.");
    }
  }

  public T pop() {
    if (index > 0) {
      return (T) storage.remove(--index);
    } else {
      throw new RuntimeException("Cannot return item. The stack is empty");
    }
  }
}

public class GenericCast {
  public static final int SIZE = 10;

  public static void main(String[] args) {
    FixedSizeStack<String> strings = new FixedSizeStack<String>(SIZE);
    try {
      for (String s : "A B C D E F G H I J".split(" ")) {
        strings.push(s);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      for (int i = 0; i < SIZE; i++) {
        String s = strings.pop();
        System.out.print(s + " ");
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
