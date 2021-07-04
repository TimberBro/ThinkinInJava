package com.test.generics.coffee;

public class Mocha extends Coffee {
  public static class Factory
      implements com.test.typeinfo.factory.Factory<Mocha> {
    public Mocha create() { return new Mocha(); }
  }
}
