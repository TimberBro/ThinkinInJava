package com.test.generics.coffee;

public class Cappuccino extends Coffee {
  public static class Factory
      implements com.test.typeinfo.factory.Factory<Cappuccino> {
    public Cappuccino create() { return new Cappuccino(); }
  }
}
