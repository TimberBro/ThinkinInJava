//: net/mindview/util/TwoTuple.java
package com.test.util;

import java.util.Objects;

public class TwoTuple<A, B> implements Comparable<TwoTuple<A, B>> {

  public final A first;
  public final B second;

  public TwoTuple(A a, B b) {
    first = a;
    second = b;
  }

  public String toString() {
    return "(" + first + ", " + second + ")";
  }

  @Override
  public int compareTo(TwoTuple<A, B> o) {
    int res = ((Comparable<A>) first).compareTo(o.first);
    if (res != 0) {
      return res;
    }
    return ((Comparable<B>) second).compareTo(o.second);
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof TwoTuple) {
      @SuppressWarnings("unchecked") TwoTuple<A, B> obj = (TwoTuple<A, B>) o;
      return (Objects.equals(first, obj.first)) && (Objects.equals(second, obj.second));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int result = 17;
    if (first != null) {
      result = result * 37 + first.hashCode();
    }
    if (second != null) {
      result = result * 37 + second.hashCode();
    }
    return result;
  }

  public A getFirst() {
    return first;
  }

  public B getSecond() {
    return second;
  }
} ///:~
