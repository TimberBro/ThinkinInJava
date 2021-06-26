// : typeinfo/pets/Cat.java
package com.test.typeinfo.pets;

public class Gerbil extends Pet {

  public static class Factory implements com.test.typeinfo.factory.Factory<Gerbil> {
    public Gerbil create() {
      return new Gerbil();
    }
  }
} /// :~
