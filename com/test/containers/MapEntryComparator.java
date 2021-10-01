package com.test.containers;

import java.util.Comparator;

class MapEntryComparator<K, V> implements Comparator<MapEntry<K, V>> {
  public int compare(MapEntry<K, V> o1, MapEntry<K, V> o2) {
    Comparable<K> c1 = (Comparable<K>) o1.getKey();
    return c1.compareTo(o2.getKey());
  }
}
