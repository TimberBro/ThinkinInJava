// : typeinfo/pets/EgyptianMau.java
package com.test.typeinfo.pets;

public class EgyptianMau extends Cat {

  public static class Factory implements com.test.typeinfo.factory.Factory<EgyptianMau> {
    public EgyptianMau create() {
      return new EgyptianMau();
    }
  }
} /// :~
