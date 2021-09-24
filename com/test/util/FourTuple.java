//: net/mindview/util/FourTuple.java
package com.test.util;

import java.util.Objects;

public class FourTuple<A, B, C, D> implements Comparable<FourTuple<A, B, C, D>> {

  private ThreeTuple<A, B, C> threeTuple;
  public final D fourth;

  public FourTuple(A a, B b, C c, D d) {
    threeTuple = new ThreeTuple(a, b, c);
    fourth = d;
  }

  public A getFirst() {
    return threeTuple.getFirst();
  }

  public B getSecond() {
    return threeTuple.getSecond();
  }

  public C getThird() {
    return threeTuple.getThird();
  }

  public D getFourth() {
    return fourth;
  }

  public String toString() {
    return "(" + getFirst() + ", " + getSecond() + ", " + getThird() + ", " + fourth + ")";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    @SuppressWarnings("unchecked")
    FourTuple<A, B, C, D> fourTuple = (FourTuple<A, B, C, D>) o;
    return Objects.equals(threeTuple, fourTuple.threeTuple) && Objects
        .equals(fourth, fourTuple.fourth);
  }

  @Override
  public int hashCode() {
    int result = threeTuple.hashCode();
    if (fourth != null) {
      result = result * 37 + result;
    }
    return result;
  }

  @Override
  public int compareTo(FourTuple<A, B, C, D> o) {
    int res = threeTuple.compareTo(o.threeTuple);
    if (res != 0) {
      return res;
    }
    return ((Comparable<D>) fourth).compareTo(o.fourth);
  }
} ///:~
