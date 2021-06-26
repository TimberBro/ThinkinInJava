// : typeinfo/pets/Rodent.java
package com.test.typeinfo.pets;

public class Rodent extends Pet {

  public static class Factory implements com.test.typeinfo.factory.Factory<Rodent> {
    public Rodent create() {
      return new Rodent();
    }
  }
} /// :~
