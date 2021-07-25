package com.test.generics;

public class Generic1<T> {
  void set(T type) {
    type.getClass().getSimpleName();
  }
}
