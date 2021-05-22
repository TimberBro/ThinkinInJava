package com.test.holding;

import com.test.util.Pet;
import com.test.util.Pets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class PetSequence {
  protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {
  public Iterator<Pet> iterator() {
    return new Iterator<Pet>() {
      private int index = 0;

      public boolean hasNext() {
        return index < pets.length;
      }

      public Pet next() {
        return pets[index++];
      }

      public void remove() { // Not implemented
        throw new UnsupportedOperationException();
      }
    };
  }

  public Iterable<Pet> reversed() {
    return new Iterable<Pet>() {
      public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
          private int index = pets.length - 1;

          public boolean hasNext() {
            return index > -1;
          }

          public Pet next() {
            return pets[index--];
          }

          public void remove() { // Not implemented
            throw new UnsupportedOperationException();
          }
        };
      }
    };
  }

  public Iterable<Pet> randomized() {
    return new Iterable<Pet>() {
      public Iterator<Pet> iterator() {
        List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
        Collections.shuffle(shuffled);
        return shuffled.iterator();
      }
    };
  }

  public static void main(String[] args) {
    NonCollectionSequence nc = new NonCollectionSequence();
    for (Pet pet : nc) {
      System.out.print(pet + " ");
    }
    System.out.println();
    for (Pet pet : nc.reversed()) {
      System.out.print(pet + " ");
    }
    System.out.println();
    for (Pet pet : nc.randomized()) {
      System.out.print(pet + " ");
    }
  }
}
