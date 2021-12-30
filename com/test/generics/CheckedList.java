package com.test.generics;

import com.test.generics.coffee.*;
import com.test.typeinfo.pets.Cat;
import java.util.*;

public class CheckedList {
  @SuppressWarnings("unchecked")
  static void oldStyleMethod(List probablyDogs) {
    probablyDogs.add(new Cat());
  }

  public static void main(String[] args) {
    List<Latte> latte = new ArrayList<>();
    oldStyleMethod(latte); // Quietly accepts a Cat
    List<Latte> latte2 = Collections.checkedList(new ArrayList<Latte>(), Latte.class);
    try {
      oldStyleMethod(latte2); // Throws an exception
    } catch (Exception e) {
      System.out.println(e);
    }
    // Derived types work fine:
    List<Coffee> pets = Collections.checkedList(new ArrayList<Coffee>(), Coffee.class);
    pets.add(new Mocha());
    pets.add(new Latte());
  }
}
