package com.test.exceptions;

import com.test.innerclasses.Selector;

class Sequence12 {
  private Object[] items;
  private int next = 0;

  public Sequence12(int size) {
    items = new Object[size];
  }

  public void add(Object x) {
    if (next < items.length) {
      items[next++] = x;
    } else {
      throw new SequenceOverflowException();
    }
  }

  private class SequenceSelector implements Selector {
    private int i = 0;

    public boolean end() {
      return i == items.length;
    }

    public Object current() {
      return items[i];
    }

    public void next() {
      if (i < items.length) {
        i++;
      }
    }
  }

  public Selector selector() {
    return new SequenceSelector();
  }

  public static void main(String[] args) {
    Sequence12 sequence = new Sequence12(10);
    for (int i = 0; i < 12; i++) {
      sequence.add(Integer.toString(i));
    }
    Selector selector = sequence.selector();
    while (!selector.end()) {
      System.out.print(selector.current() + " ");
      selector.next();
    }
  }
}

class SequenceOverflowException extends RuntimeException {}