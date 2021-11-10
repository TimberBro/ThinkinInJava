package com.test.holding;

import java.util.Iterator;

public class Sequence9 {
  private Object[] items;
  private int next = 0;

  public Sequence9(int size) {
    items = new Object[size];
  }

  public void add(Object x) {
    if (next < items.length) {
      items[next++] = x;
    }
  }

  private class SequenceIterator implements Iterator<Object> {
    private int i = 0;

    public boolean end() {
      return i == items.length;
    }

    public Object current() {
      return items[i];
    }

    @Override
    public boolean hasNext() {
      return i < items.length;
    }

    public Object next() {
      if (hasNext()) {
        return items[i++];
      }
      else return null;
    }
  }

  public Iterator<Object> iterator() {
    return new SequenceIterator();
  }

  public static void main(String[] args) {
    Sequence9 sequence = new Sequence9(10);
    for (int i = 0; i < 10; i++) {
      sequence.add(Integer.toString(i));
      }
    Iterator<Object> iterator = sequence.iterator();
    while (iterator.hasNext()) {
      System.out.print(iterator.next() + " ");
    }
  }
}
