package com.test.arrays;

import com.test.util.CountingGenerator;

public class StringFromCharacterGenerator {
  public static void main(String[] args) {
    CountingGenerator.Character cg = new CountingGenerator.Character();
    char[] ca = new char[7];
    for (int i = 0; i < ca.length; i++) {
      ca[i] = cg.next();
    }
    System.out.println(new String(ca));
  }
}
