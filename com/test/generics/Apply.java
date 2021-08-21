package com.test.generics;

import com.test.typeinfo.pets.Cymric;
import com.test.typeinfo.pets.Dog;
import com.test.typeinfo.pets.Pet;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Apply {
  public static <T, S extends Iterable<? extends T>> void apply(S seq, Method f, Object... args) {
    try {
      for (T t : seq) {
        f.invoke(t, args);
      }
    } catch (Exception e) {
      // Failures are programmer errors
      throw new RuntimeException(e);
    }
  }
}

class FilledList<T> extends ArrayList<T> {
  public FilledList(Class<? extends T> type, int size) {
    try {
      for (int i = 0; i < size; i++) {
        // Assumes default constructor:
        add(type.newInstance());
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

class ApplyTest {
  public static void main(String[] args) throws Exception {
    List<Pet> pets = new ArrayList<Pet>();
    for (int i = 0; i < 10; i++) {
      pets.add(new Pet());
    }
    Apply.apply(pets, Pet.class.getMethod("speak"));
    List<Cymric> cymrics = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      cymrics.add(new Cymric());
    }
    Apply.apply(cymrics, Pet.class.getMethod("speak"));

    Apply.apply(new FilledList<Pet>(Pet.class, 10), Pet.class.getMethod("speak"));
    Apply.apply(new FilledList<Pet>(Dog.class, 10), Pet.class.getMethod("speak"));

    SimpleQueue<Pet> shapeQ = new SimpleQueue<>();
    for (int i = 0; i < 5; i++) {
      shapeQ.add(new Pet());
      shapeQ.add(new Cymric());
      shapeQ.add(new Dog());
    }
    Apply.apply(shapeQ, Pet.class.getMethod("speak"));
  }
}
