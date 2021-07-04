// : typeinfo/pets/Manx.java
package com.test.typeinfo.pets;

public class Manx extends Cat {

  public static class Factory implements com.test.typeinfo.factory.Factory<Manx> {
    public Manx create() {
      return new Manx();
    }
  }
} /// :~
