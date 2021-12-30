// : typeinfo/pets/Mouse.java
package com.test.typeinfo.pets;

public class Mouse extends Rodent {

  public static class Factory implements com.test.typeinfo.factory.Factory<Mouse> {
    public Mouse create() {
      return new Mouse();
    }
  }
} /// :~
