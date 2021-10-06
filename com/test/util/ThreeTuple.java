//: net/mindview/util/ThreeTuple.java
package com.test.util;

import java.util.Objects;

public class ThreeTuple<A, B, C> implements Comparable<ThreeTuple<A, B, C>> {

  private TwoTuple<A, B> twoTuple;
  public final C third;

  public ThreeTuple(A a, B b, C c) {
    twoTuple = new TwoTuple<>(a, b);
    third = c;
  }

  public String toString() {
    return "(" + twoTuple.getFirst() + ", " + twoTuple.getSecond() + ", " + third + ")";
  }

  public A getFirst() {
    return twoTuple.getFirst();
  }

  public B getSecond() {
    return twoTuple.getSecond();
  }

  public C getThird() {
    return third;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    @SuppressWarnings("unchecked") ThreeTuple<A, B, C> that = (ThreeTuple<A, B, C>) o;
    return Objects.equals(twoTuple, that.twoTuple) && Objects.equals(third, that.third);
  }

  @Override
  public int hashCode() {
    int result = twoTuple.hashCode();
    if (third != null) {
      result = result * 37 + result;
    }
    return result;
  }

  @Override
  public int compareTo(ThreeTuple<A, B, C> o) {
    int res = twoTuple.compareTo(o.twoTuple);
    if (res != 0) {
      return res;
    }
    return ((Comparable<C>) third).compareTo(o.third);
  }
} ///:~
