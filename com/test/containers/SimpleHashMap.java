package com.test.containers;

import com.test.util.Countries;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V> {

  // Choose a prime number for the hash table
  // size, to achieve a uniform distribution:
  private static final int initialCapacity = 16;
  private int count;
  private static final double loadFactor = 0.75;
  private int capacity = initialCapacity;
  private int threshold = (int) (capacity * loadFactor);
  // You can't have a physical array of generics,
  // but you can upcast to one:
  @SuppressWarnings("unchecked")
  LinkedList<MapEntry<K, V>>[] buckets = new LinkedList[capacity];

  public V put(K key, V value) {
    V oldValue = null;
    int index = Math.abs(key.hashCode()) % capacity;
    if (buckets[index] == null) {
      buckets[index] = new LinkedList<>();
    }
    LinkedList<MapEntry<K, V>> bucket = buckets[index];
    MapEntry<K, V> pair = new MapEntry<>(key, value);
    boolean found = false;
    ListIterator<MapEntry<K, V>> it = bucket.listIterator();
    while (it.hasNext()) {
      MapEntry<K, V> iPair = it.next();
      if (iPair.getKey().equals(key)) {
        oldValue = iPair.getValue();
        it.set(pair); // Replace old with new
        found = true;
        // System.out.println("Collision was found on key: " + iPair.getKey() + ".\nPrevious value =
        // " + oldValue);
        break;
      }
    }
    if (!found) {
      if (count >= threshold) {
        rehash();
      }
      if (buckets[index] == null) {
        buckets[index] = new LinkedList<>();
      }
      buckets[index].add(pair);
      ++count;
    }
    return oldValue;
  }

  public V get(Object key) {
    int index = Math.abs(key.hashCode()) % capacity;
    if (buckets[index] == null) {
      return null;
    }
    for (MapEntry<K, V> iPair : buckets[index]) {
      if (iPair.getKey().equals(key)) {
        return iPair.getValue();
      }
    }
    return null;
  }

  public Set<Entry<K, V>> entrySet() {
    Set<Map.Entry<K, V>> set = new HashSet<>();
    for (LinkedList<MapEntry<K, V>> bucket : buckets) {
      if (bucket == null) {
        continue;
      }
      for (MapEntry<K, V> mpair : bucket) {
        set.add(mpair);
      }
    }
    return set;
  }

  // Almost all copied from AbstractMap and from get method.
  @Override
  public V remove(Object key) {
    int index = Math.abs(key.hashCode()) % capacity;
    if (buckets[index] == null) {
      return null;
    }
    Iterator<MapEntry<K, V>> it = buckets[index].iterator();
    while (it.hasNext()) {
      MapEntry<K, V> iPair = it.next();
      if (iPair.getKey().equals(key)) {
        V value = iPair.getValue();
        it.remove();
        return value;
      }
    }
    return null;
  }

  private void rehash() {
    // Set new parameters for HashMap
    capacity = nextPrime(capacity * 2);
    buckets = new LinkedList[capacity];
    threshold = (int) (capacity * loadFactor);
    count = 0;
    // Get set of current map entries
    Iterator<Entry<K, V>> iterator = entrySet().iterator();
    while (iterator.hasNext()) {
      Map.Entry<K, V> entry = iterator.next();
      put(entry.getKey(), entry.getValue());
    }
  }

  private boolean isPrime(int n) {
    if (n <= 1) {
      return false;
    }
    if (n <= 3) {
      return true;
    }
    if (n % 2 == 0 || n % 3 == 0) {
      return false;
    }
    for (int i = 5; i * i <= n; i = i + 6) {
      if (n % i == 0 || n % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }

  private int nextPrime(int n) {
    // Base case
    if (n <= 1) {
      return 2;
    }
    int prime = n;
    boolean found = false;
    while (!found) {
      prime++;

      if (isPrime(prime)) {
        found = true;
      }
    }
    return prime;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void clear() {
    buckets = new LinkedList[capacity];
  }

  public static void main(String[] args) {
    SimpleHashMap<String, String> m = new SimpleHashMap<>();
    m.putAll(Countries.capitals(40));
    System.out.println(m);
    System.out.println(m.get("ERITREA"));
    System.out.println(m.entrySet());
    System.out.println(m.remove("ANGOLA"));
    System.out.println(m);
    m.clear();
    System.out.println(m);
  }
}
