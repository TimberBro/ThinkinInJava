package com.test.containers;

import com.test.util.Countries;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SlowMap<K, V> extends AbstractMap<K, V> {
  private List<K> keys = new ArrayList<>();
  private List<V> values = new ArrayList<>();

  public V put(K key, V value) {
    V oldValue = get(key); // The old value or null
    if (!keys.contains(key)) {
      keys.add(key);
      values.add(value);
    } else {
      values.set(keys.indexOf(key), value);
    }
    return oldValue;
  }

  public V get(Object key) { // key is type Object, not K
    if (!keys.contains(key)) {
      return null;
    }
    return values.get(keys.indexOf(key));
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
          return index < keys.size() - 1;
        }

        public Map.Entry<K, V> next() {
          ++index;
          return new MapEntry<>(keys.get(index), values.get(index));
        }

        public void remove() {
          keys.remove(index);
          values.remove(index);
          // Before move to the next key
          index--;
        }
      };
    }

    // Adapted from HashMap
    public final int size() {
      return keys.size();
    }

    // From HashMap
    public final boolean contains(Object o) {
      if (!(o instanceof Map.Entry)) {
        return false;
      }
      Map.Entry<K, V> e = (Map.Entry<K, V>) o;
      K key = e.getKey();
      if (keys.contains(key)) {
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
        keys.remove(key);
        values.remove(val);
        return true;
      }
      return false;
    }

    @Override
    public void clear() {
      keys.clear();
      values.clear();
    }
  }

  public static void main(String[] args) {
    SlowMap<String, String> m = new SlowMap<>();
    m.putAll(Countries.capitals(15));
    System.out.println(m);
    System.out.println(m.get("BULGARIA"));
    System.out.println(m.entrySet());
    m.clear();
    System.out.println(m.entrySet());
  }
}
