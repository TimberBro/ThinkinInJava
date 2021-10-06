package com.test.containers;

import com.test.util.Countries;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ArraySimpleHashSet<T> extends AbstractSet<T> {

  static final int SIZE = 997;

  @SuppressWarnings("unchecked")
  ArrayList<T>[] buckets = new ArrayList[SIZE];

  @Override
  public boolean add(T key) {
    int index = Math.abs(key.hashCode()) % SIZE;
    if (buckets[index] == null) {
      buckets[index] = new ArrayList<>();
    }
    ArrayList<T> bucket = buckets[index];
    ListIterator<T> it = bucket.listIterator();
    while (it.hasNext()) {
      if (it.next().equals(key)) {
        return false;
      }
    }

    it.add(key);
    return true;
  }

  public boolean contains(Object key) {
    int index = Math.abs(key.hashCode()) % SIZE;
    if (buckets[index] == null) {
      return false;
    }
    Iterator<T> it = buckets[index].iterator();
    while (it.hasNext()) {
      if (it.next().equals(key)) {
        return true;
      }
    }
    return false;
  }

  // Need more information about HashSet. Don't understand how to iterate through objects in
  // hashset.
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int count;
      int index1;
      int index2;
      boolean canRemove;

      @Override
      public boolean hasNext() {
        return count < size();
      }

      public T next() {
        if (hasNext()) {
          canRemove = true;
          ++count;
          while (true) {
            // Position of the next non-empty bucket
            while (buckets[index1] == null) {
              ++index1;
            }
            // Position of the next item to return
            try {
              return buckets[index1].get(index2++);
            } catch (IndexOutOfBoundsException e) {
              // Continue search from the next bucket
              ++index1;
              index2 = 0;
            }
          }
        }
        throw new NoSuchElementException();
      }

      @Override
      public void remove() {
        if (canRemove) {
          canRemove = false;
          buckets[index1].remove(--index2);
          --count;
        } else {
          throw new IllegalStateException();
        }
      }
    };
  }

  @Override
  public int size() {
    int size = 0;
    for (ArrayList<T> bucket : buckets) {
      if (bucket != null) {
        size += bucket.size();
      }
    }
    return size;
  }

  public static void main(String[] args) {
    SimpleHashSet<String> m = new SimpleHashSet<>();
    m.addAll(Countries.names(10));
    m.addAll(Countries.names(10));
    System.out.println("m = " + m);
    System.out.println("m.size() = " + m.size());
    Iterator<String> it = m.iterator();
    System.out.println("it.next()= " + it.next());
    it.remove();
    System.out.println("it.next()= " + it.next());
    System.out.println("m = " + m);
    m.remove("ALGERIA");
    System.out.println("m = " + m);
  }
}
