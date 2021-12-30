package com.test.generics.coffee;

public class Latte extends Coffee {
  public static class Factory
      implements com.test.typeinfo.factory.Factory<Latte> {
    public Latte create() { return new Latte(); }
  }
}
