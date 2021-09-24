//: net/mindview/util/FiveTuple.java
package com.test.util;

import java.util.Objects;

public class FiveTuple<A, B, C, D, E> implements Comparable<FiveTuple<A, B, C, D, E>> {

  private FourTuple<A, B, C, D> fourthTuple;
  public final E fifth;

  public FiveTuple(A a, B b, C c, D d, E e) {
    fourthTuple = new FourTuple<>(a, b, c, d);
    fifth = e;
  }

  public A getFirst() {
    return fourthTuple.getFirst();
  }

  public B getSecond() {
    return fourthTuple.getSecond();
  }

  public C getThird() {
    return fourthTuple.getThird();
  }

  public D getFourth() {
    return fourthTuple.getFourth();
  }

  public E getFifth() {
    return fifth;
  }

  public String toString() {
    return "(" + getFirst() + ", " + getSecond() + ", " + getThird() + ", " + getFourth() + ", "
        + fifth + ")";
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
    FiveTuple<A, B, C, D, E> fiveTuple = (FiveTuple<A, B, C, D, E>) o;
    return Objects.equals(fourthTuple, fiveTuple.fourthTuple) && Objects
        .equals(fifth, fiveTuple.fifth);
  }

  @Override
  public int hashCode() {
    int result = fourthTuple.hashCode();
    if (fifth != null) {
      result = result * 37 + result;
    }
    return result;
  }

  @Override
  public int compareTo(FiveTuple<A, B, C, D, E> o) {
    int res = fourthTuple.compareTo(o.fourthTuple);
    if (res != 0) {
      return res;
    }
    return ((Comparable<E>) fifth).compareTo(o.fifth);
  }
} ///:~
