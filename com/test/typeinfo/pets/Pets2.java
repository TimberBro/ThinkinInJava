package com.test.typeinfo.pets;

import com.test.typeinfo.factory.Factory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pets2 {
  public static class PetFactoryCreator extends PetCreator {
    static List<Factory<? extends Pet>> petFactories =
        Arrays.asList(
            new Cat.Factory(),
            new Pug.Factory(),
            new EgyptianMau.Factory(),
            new Manx.Factory(),
            new Cymric.Factory(),
            new Rat.Factory(),
            new Mouse.Factory(),
            new Hamster.Factory(),
            new Dog.Factory(),
            new Rodent.Factory(),
            new Gerbil.Factory());

    @Override
    public List<Class<? extends Pet>> types() {
      throw new UnsupportedOperationException();
    }

    @Override
    public Pet randomPet() {
      return Pet.createRandom();
    }
  }

  public static PetCreator creator = new PetFactoryCreator();

  public static Pet[] createArray(int size) {
    return creator.createArray(size);
  }

  public static ArrayList<Pet> arrayList(int size) {
    return creator.arrayList(size);
  }
}
