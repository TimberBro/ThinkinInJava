
// : typeinfo/pets/Cat.java
package com.test.typeinfo.pets;

public class Cat extends Pet {
  public Cat(String name) {
    super(name);
  }

  public Cat() {
    super();
  }

  @Override
  public void speak() {
    System.out.println("Cat.speak()");

  }
} /// :~
