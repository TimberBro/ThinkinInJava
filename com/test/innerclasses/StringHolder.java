package com.test.innerclasses;

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

  private class ReverseSelector implements Selector {
    private int i = items.length;

    @Override
    public boolean end() {
      return i == 0;
    }

    @Override
    public Object current() {
      return items[i-1];
    }

    @Override
    public void next() {
      if (i > 0) {
        i--;
      }
    }
  }

  public Selector selector() {
    return new SequenceSelector();
  }

  public Selector reverseSelector() {
    return new ReverseSelector();
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
    System.out.println("Your array is:");
    Selector selector = sequence.selector();
    while (!selector.end()) {
      System.out.println(selector.current() + " ");
      selector.next();
    }
    System.out.println("Now array will be printed backwards:");
    Selector reverseSelector = sequence.reverseSelector();
    while (!reverseSelector.end()) {
      System.out.println(reverseSelector.current() + " ");
      reverseSelector.next();
    }
  }
}
