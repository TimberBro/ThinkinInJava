package com.test.containers;

import com.test.util.Countries;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {
  private List<MapEntry<K, V>> entries = new ArrayList<>();
  // private List<V> values = new ArrayList<>();
  private Comparator<MapEntry<K, V>> comparator = new MapEntryComparator<>();

  public V put(K key, V value) {
    MapEntry<K, V> candidate = new MapEntry<>(key, value);
    V oldValue = candidate.getValue(); // The old value or null
    if (!entries.contains(candidate)) {
      entries.add(candidate);
      Collections.sort(entries, comparator);
    } else {
      entries.set(entries.indexOf(candidate), candidate);
    }
    return oldValue;
  }

  public V get(Object key) { // key is type Object, not K
    MapEntry<K, V> entry = getEntry(key);
    return entry == null ? null : entry.getValue();
  }

  protected MapEntry<K, V> getEntry(Object key) {
    MapEntry<K, V> searchEntry = new MapEntry<>((K) key, null);
    int index = Collections.binarySearch(entries, searchEntry, comparator);
    if (index >= 0) {
      return entries.get(index);
    }
    return null;
  }

  private EntrySet entrySet;

  // From HashMap
  @Override
  public Set<Map.Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> es;
    return (es = entrySet) == null ? (entrySet = new EntrySet()) : es;
  }

  // Create view into the Map to allow modifications
  class EntrySet extends AbstractSet<Entry<K, V>> {

    @Override
    public Iterator<Entry<K, V>> iterator() {
      return new Iterator<Map.Entry<K, V>>() {
        private int index = -1;

        public boolean hasNext() {
          return index < entries.size() - 1;
        }

        public Map.Entry<K, V> next() {
          ++index;
          return entries.get(index);
        }

        public void remove() {
          entries.remove(index);
          // Before move to the next key
          index--;
        }
      };
    }

    // Adapted from HashMap
    public final int size() {
      return entries.size();
    }

    // From HashMap
    public final boolean contains(Object o) {
      if (!(o instanceof Map.Entry)) {
        return false;
      }
      Map.Entry<K, V> e = (Map.Entry<K, V>) o;
      K key = e.getKey();
      if (entries.contains(key)) {
        return e.equals(new MapEntry<>(key, get(key)));
      }
      return false;
    }

    @Override
    public boolean remove(Object o) {
      if (contains(o)) {
        MapEntry<K, V> e = (MapEntry<K, V>) o;
        K key = e.getKey();
        V val = e.getValue();
        entries.remove(key);
        return true;
      }
      return false;
    }

    @Override
    public void clear() {
      entries.clear();
    }
  }

  public static void main(String[] args) {
    SlowMap<String, String> m = new SlowMap<>();
    m.putAll(Countries.capitals(15));
    System.out.println(m);
    System.out.println(m.get("BENIN"));
    System.out.println(m.entrySet());
    m.clear();
    System.out.println(m.entrySet());
  }
}
