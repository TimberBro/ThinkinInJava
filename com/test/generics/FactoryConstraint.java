package com.test.generics;

interface FactoryI<T> {
  T create(int i);
}

class Foo2<T> {
  private T x;

  public <F extends FactoryI<T>> Foo2(F factory) {
    x = factory.create(0);
  }
  // . . .
}

class IntegerFactory implements FactoryI<Integer> {
  public Integer create(int i) {
    return new Integer(i);
  }
}

class Widget {
  private final int id;

  public static class Factory implements FactoryI<Widget> {
    public Widget create(int i) {
      return new Widget(i);
    }
  }

  Widget(int i) {
    this.id = i;
  }

  @Override
  public String toString() {
    return "Widget{" + "id=" + id + '}';
  }
}

public class FactoryConstraint {
  public static void main(String[] args) {
    new Foo2<Integer>(new IntegerFactory());
    new Foo2<Widget>(new Widget.Factory());
  }
}
