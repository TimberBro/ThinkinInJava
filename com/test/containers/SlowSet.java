package com.test.containers;

import com.test.util.Countries;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SlowSet<T> extends AbstractSet<T> {
  private List<T> keys = new ArrayList<>();

  @Override
  public Iterator<T> iterator() {
    return keys.iterator();
  }

  @Override
  public int size() {
    return keys.size();
  }

  @Override
  public boolean add(T object) {
    if (!keys.contains(object)) {
      keys.add(object);
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    SlowSet<String> slowSet = new SlowSet<String>();
    slowSet.addAll(Countries.names(10));
    System.out.println(slowSet);
    slowSet.addAll(Countries.names(20));
    System.out.println(slowSet);
  }
}
