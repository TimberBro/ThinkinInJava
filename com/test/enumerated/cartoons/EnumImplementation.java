package com.test.enumerated.cartoons;

import com.test.util.Generator;
import java.util.Random;

enum CartoonCharacter {
  SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
  private static Random rand = new Random(47);

  public static CartoonCharacter next() {
    return values()[rand.nextInt(values().length)];
  }
}

public class EnumImplementation {

  // If you create static method instead of implementing an interface, you don't need an instance
  // of ENUM, but you can't use method, that requires Generator.
  public static <T> void printNext(CartoonCharacter rg) {
    System.out.print(rg.next() + ", ");
  }

  public static void main(String[] args) {
    // Choose any instance:
    CartoonCharacter cc = CartoonCharacter.BOB;
    for (int i = 0; i < 10; i++) {
      printNext(cc);
    }
  }
}
