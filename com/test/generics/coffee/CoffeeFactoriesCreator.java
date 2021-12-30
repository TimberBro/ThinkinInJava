package com.test.generics.coffee;

import com.test.util.Generator;
import java.util.Iterator;

public class CoffeeFactoriesCreator implements Generator<Coffee>, Iterable<Coffee> {

  private int size = 0;

  @Override
  public Coffee next() {
    return Coffee.createRandom();
  }

  public CoffeeFactoriesCreator(int size) {
    this.size = size;
  }

  class CoffeeIterator implements Iterator<Coffee> {
    int count = size;

    public boolean hasNext() {
      return count > 0;
    }

    public Coffee next() {
      count--;
      return CoffeeFactoriesCreator.this.next();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }
  }

  @Override
  public Iterator<Coffee> iterator() {
    return new CoffeeIterator();
  }

  public static void main(String[] args) {
    for (Coffee c : new CoffeeFactoriesCreator(10)) {
      System.out.println(c);
    }
  }
}
