package com.test.generics;

abstract class AbstractGeneric<T extends AbstractGeneric> {
  abstract T get(T type);

  T callGet() {
    return get(null);
  }
}

class ExtendedGeneric extends AbstractGeneric<ExtendedGeneric> {

  @Override
  ExtendedGeneric get(ExtendedGeneric type) {
    if (type == null) {
      return this;
    } else {
      return type;
    }
  }
}

public class TestAbstractGeneric {
  public static void main(String[] args) {
    ExtendedGeneric extendedGeneric = new ExtendedGeneric();
    System.out.println((extendedGeneric.callGet()).getClass().getSimpleName());
  }
}
