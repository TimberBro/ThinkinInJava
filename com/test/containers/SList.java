package com.test.containers;

interface SIterator<T> {
  boolean hasNext();

  Link<T> next();

  void remove();

  void add(T object);
}

class Link<T> {
  T storedObject;
  Link<T> nextObject;

  Link(T object, Link<T> nextObject) {
    storedObject = object;
    this.nextObject = nextObject;
  }

  Link(T object) {
    this(object, null);
  }
}

public class SList<T> {

  private final Link<T> header = new Link<>(null);

  SList() {
    header.nextObject = header;
  }

  public String toString() {
    if (header.nextObject == null) return "SList: []";
    System.out.println("SList: [");
    SIterator<T> it = this.iterator();
    StringBuilder s = new StringBuilder();
    while (it.hasNext()) {
      s.append(it.next() + (it.hasNext() ? ", " : ""));
    }
    return s + "]";
  }

  private class SIteratorImpl implements SIterator<T> {

    Link<T> currentElement;

    SIteratorImpl(Link<T> link) {
      currentElement = link;
    }

    @Override
    public boolean hasNext() {
      return currentElement.nextObject != null;
    }

    @Override
    public Link<T> next() {
      currentElement = currentElement.nextObject;
      return currentElement;
    }

    @Override
    public void remove() {
      if (currentElement.nextObject != null) {
        currentElement.nextObject = currentElement.nextObject.nextObject;
      }
    }

    @Override
    public void add(T object) {
      currentElement.nextObject = new Link<>(object, currentElement.nextObject);
      currentElement = currentElement.nextObject;
    }
  }

  public SIterator<T> iterator() {
    return new SIteratorImpl(header);
  }
  // TODO: 03.09.2021 Implement SListIterator class
  public static void main(String[] args) {
    SList<String> sList = new SList<>();
    SIterator<String> iterator = sList.iterator();
    iterator.add("Hello");
    iterator.add("world");
    System.out.println(sList.toString());
  }
}
