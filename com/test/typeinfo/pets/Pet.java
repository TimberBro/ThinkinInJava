// : typeinfo/pets/Pet.java
package com.test.typeinfo.pets;

import com.test.typeinfo.factory.Factory;
import com.test.util.Individual;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pet extends Individual {
  public Pet(String name) {
    super(name);
  }

  public Pet() {
    super();
  }

  public String toString() {
    return getClass().getSimpleName();
  }

  static List<Factory<? extends Pet>> petFactories = new ArrayList<Factory<? extends Pet>>();

  static {
    // Collections.addAll() gives an "unchecked generic
    // array creation ... for varargs parameter" warning.
    petFactories.add(new com.test.typeinfo.pets.Cat.Factory());
    petFactories.add(new com.test.typeinfo.pets.Cymric.Factory());
    petFactories.add(new com.test.typeinfo.pets.Dog.Factory());
    petFactories.add(new com.test.typeinfo.pets.Gerbil.Factory());
    petFactories.add(new com.test.typeinfo.pets.Manx.Factory());
    petFactories.add(new com.test.typeinfo.pets.Mouse.Factory());
    petFactories.add(new com.test.typeinfo.pets.Mutt.Factory());
    petFactories.add(new com.test.typeinfo.pets.Pug.Factory());
    petFactories.add(new com.test.typeinfo.pets.Rat.Factory());
    petFactories.add(new com.test.typeinfo.pets.Rodent.Factory());
  }

  private static Random rand = new Random(47);

  public static com.test.typeinfo.pets.Pet createRandom() {
    int n = rand.nextInt(petFactories.size());
    return petFactories.get(n).create();
  }
} /// :~
