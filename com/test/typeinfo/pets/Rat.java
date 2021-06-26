// : typeinfo/pets/Rat.java
package com.test.typeinfo.pets;

public class Rat extends Rodent {

  public static class Factory implements com.test.typeinfo.factory.Factory<Rat> {
    public Rat create() {
      return new Rat();
    }
  }
} /// :~
