package com.test.holding;

import com.test.innerclasses.Selector;
import java.util.ArrayList;
import java.util.List;

public class Sequence4 {
  private final List<Object> items = new ArrayList<>();

  public void test() {
    System.out.println("test()");
  }

  public void add(Object x) {
    items.add(x);
  }

  private class SequenceSelector implements Selector {
    private int i = 0;

    public boolean end() {
      return i == items.size();
    }

    public Object current() {
      return items.get(i);
    }

    public void next() {
      if (i < items.size()) {
        i++;
      }
    }

    public Sequence4 sequence4() {
      return Sequence4.this;
    }
  }

  public Selector selector() {
    return new SequenceSelector();
  }

  public static void main(String[] args) {
    Sequence4 sequence = new Sequence4();
    for (int i = 0; i < 10; i++) {
      sequence.add(Integer.toString(i));
    }
    Selector selector = sequence.selector();
    while (!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }

     ((SequenceSelector) selector).sequence4().test();
  }
}
