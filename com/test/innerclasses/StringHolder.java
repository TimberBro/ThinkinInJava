package com.test.innerclasses;

interface Selector {
  boolean end();

  Object current();

  void next();
}

class Sequence {
  private Object[] items;
  private int next = 0;

  public Sequence(int size) {
    items = new Object[size];
  }

  public void add(Object x) {
    if (next < items.length) {
      items[next++] = x;
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
}

public class StringHolder {
  private String string;

  StringHolder(String s) {
    this.string = s;
  }

  public String toString() {
    return string;
  }

  public static void main(String[] args) {
    Sequence sequence = new Sequence(4);
    sequence.add(new StringHolder("Hola!"));
    sequence.add(new StringHolder("Hello!"));
    sequence.add(new StringHolder("Привет!"));
    sequence.add(new StringHolder("Hallo!"));
    Selector selector = sequence.selector();
    while (!selector.end()) {
      System.out.println(selector.current() + " ");
      selector.next();
    }
  }
}
