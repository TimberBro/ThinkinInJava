// : typeinfo/pets/Cymric.java
package com.test.typeinfo.pets;

public class Cymric extends Manx {

  public static class Factory implements com.test.typeinfo.factory.Factory<Cymric> {
    public Cymric create() {
      return new Cymric();
    }
  }
} /// :~
