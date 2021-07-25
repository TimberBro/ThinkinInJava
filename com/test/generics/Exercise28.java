package com.test.generics;

import com.test.typeinfo.pets.Hamster;
import com.test.typeinfo.pets.Manx;
import com.test.typeinfo.pets.Mouse;
import com.test.typeinfo.pets.Pet;
import com.test.typeinfo.pets.Rodent;

public class Exercise28 {

  static <T> void contravariantMethod(Generic1<? super T> pet, T item) {
    pet.set(item);
  }

  static <T> T covariantMethod(Generic2<? extends T> pet) {
    return pet.get();
  }

  public static void main(String[] args) {
    Generic1<Rodent> generic1 = new Generic1<>();
    contravariantMethod(generic1, new Hamster());
    // java: method contravariantMethod in class com.test.generics.Exercise28 cannot be applied to given types;
    // contravariantMethod(generic1, new Manx());
    Generic2<Pet> generic2 = new Generic2<>();
    Pet pet = generic2.get(); // valid operation
    Generic2<Manx> manxGeneric2 = new Generic2<>();
    Manx manx = manxGeneric2.get();
    pet = manxGeneric2.get(); // still valid operation
  }
}
