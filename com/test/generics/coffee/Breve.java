package com.test.generics.coffee;

public class Breve extends Coffee {
  public static class Factory
      implements com.test.typeinfo.factory.Factory<Breve> {
    public Breve create() { return new Breve(); }
  }
}
