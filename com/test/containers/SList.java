package com.test.containers;

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

  public Link<T> next() {
    return nextObject;
  }

  public T getObject() {
    return storedObject;
  }

  public String toString() {
    if (storedObject == null) {
      return "null";
    }
    return storedObject.toString();
  }

  public void setNext(Link<T> object) {
    nextObject = object;
  }
}

public class SList<T> {

  private final Link<T> header = new Link<>(null);

  public String toString() {
    if (header.next() == null) {
      return "List is empty";
    }
    SIterator<T> it = this.iterator();
    StringBuilder s = new StringBuilder();
    while (it.hasNext()) {
      s.append(it.next() + (it.hasNext() ? ", " : ""));
    }
    return s.toString();
  }

  public SIterator<T> iterator() {
    return new SIterator<T>(header);
  }
}

class SIterator<T> {

  Link<T> currentElement;

  SIterator(Link<T> link) {
    currentElement = link;
  }

  public boolean hasNext() {
    return currentElement.next() != null;
  }

  public Link<T> next() {
    currentElement = currentElement.next();
    return currentElement;
  }

  public void remove() {
    if (currentElement.next() != null) {
      currentElement.setNext(currentElement.next().next());
    }
  }

  public void add(T object) {
    currentElement.setNext(new Link<>(object, currentElement.next()));
    currentElement = currentElement.next();
  }
}

class Exercise8 {
  public static void main(String[] args) {
    SList<String> sList = new SList<>();
    SIterator<String> iterator = sList.iterator();
    iterator.add("Hello");
    iterator.add("world");
    System.out.println(sList.toString());
    iterator = sList.iterator();
    iterator.remove();
    iterator.remove();
    System.out.println(sList.toString());
  }
}
