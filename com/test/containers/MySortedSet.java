package com.test.containers;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;

public class MySortedSet<T extends Comparable> implements SortedSet<T> {

  List<T> list = new LinkedList<>();

  MySortedSet(List<T> list) {
    this.list = list;
  }

  public MySortedSet() {}

  @Override
  public Comparator comparator() {
    return null;
  }

  @Override
  public SortedSet<T> subSet(T fromElement, T toElement) {
    return new MySortedSet<>(list.subList(list.indexOf(fromElement), list.indexOf(toElement)));
  }

  @Override
  public SortedSet<T> headSet(T toElement) {
    return new MySortedSet<>(list.subList(0, list.indexOf(toElement)));
  }

  @Override
  public SortedSet<T> tailSet(T fromElement) {
    return new MySortedSet<>(list.subList(list.indexOf(fromElement), list.size()));
  }

  @Override
  public T first() {
    return list.get(0);
  }

  @Override
  public T last() {
    return list.get(list.size() - 1);
  }

  @Override
  public int size() {
    return list.size();
  }

  @Override
  public boolean isEmpty() {
    return list.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return list.contains(o);
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }

  @Override
  public Object[] toArray() {
    return new Object[0];
  }

  @Override
  public Object[] toArray(Object[] a) {
    return new Object[0];
  }

  // Very tricky decision. I added object, then sort list, because I don't want to do it manually.
  @Override
  public boolean add(T o) {
    if (!list.contains(o) && o != null) {
      list.add(o);
      list.sort(Comparator.naturalOrder());
    }
    return true;
  }

  @Override
  public boolean remove(Object o) {
    return list.remove(o);
  }

  @Override
  public void clear() {
    list.clear();
  }

  @Override
  public boolean addAll(Collection c) {
    for (Object object : c) {
      if (!list.contains(object) && object != null) {
        list.add((T) object);
      }
    }
    list.sort(Comparator.naturalOrder());
    return true;
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof MySortedSet && list.equals(((MySortedSet<?>) o).list);
  }

  @Override
  public int hashCode() {
    return list.hashCode();
  }

  @Override
  public boolean removeAll(Collection c) {
    return list.removeAll(c);
  }

  @Override
  public boolean retainAll(Collection c) {
    return list.retainAll(c);
  }

  @Override
  public boolean containsAll(Collection c) {
    return list.containsAll(c);
  }

  @Override
  public String toString() {
    return "MySortedSet{" + "list=" + list + '}';
  }

  public static void main(String[] args) {
    SortedSet<String> sortedSet = new MySortedSet<>();
    Collections.addAll(sortedSet, "one two three four five six seven eight".split(" "));
    System.out.println(sortedSet);
    String low = sortedSet.first();
    String high = sortedSet.last();
    System.out.println(low);
    System.out.println(high);
    Iterator<String> it = sortedSet.iterator();
    for (int i = 0; i <= 6; i++) {
      if (i == 3) {
        low = it.next();
      }
      if (i == 6) {
        high = it.next();
      } else {
        it.next();
      }
    }
    System.out.println(low);
    System.out.println(high);
    System.out.println(sortedSet.subSet(low, high));
    System.out.println(sortedSet.headSet(high));
    System.out.println(sortedSet.tailSet(low));
  }
}
