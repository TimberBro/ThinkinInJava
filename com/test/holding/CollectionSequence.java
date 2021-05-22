package com.test.holding;

import com.test.util.Pet;
import com.test.util.Pets;
import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence implements Collection<Pet> {
  private Pet[] pets = Pets.createArray(8);

  public int size() {
    return pets.length;
  }

  @Override
  public boolean isEmpty() {
    return this.size() == 0;
  }

  @Override
  public boolean contains(Object o) {
    throw new UnsupportedOperationException();
  }

  public Iterator<Pet> iterator() {
    return new Iterator<Pet>() {
      private int index = 0;

      public boolean hasNext() {
        return index < pets.length;
      }

      public Pet next() {
        return pets[index++];
      }

      public void remove() { // Not implemented
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public Object[] toArray() {
    throw new UnsupportedOperationException();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean add(Pet pet) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean remove(Object o) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean addAll(Collection<? extends Pet> c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void clear() {
    throw new UnsupportedOperationException();
  }

  public static void main(String[] args) {
    CollectionSequence c = new CollectionSequence();
    InterfaceVsIterator.display(c);
    InterfaceVsIterator.display(c.iterator());
  }
}
