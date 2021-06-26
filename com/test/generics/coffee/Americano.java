package com.test.generics.coffee;

public class Americano extends Coffee {
  public static class Factory
      implements com.test.typeinfo.factory.Factory<Americano> {
    public Americano create() { return new Americano(); }
  }
}
