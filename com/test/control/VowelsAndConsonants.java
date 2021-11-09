package com.test.control;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

enum CharType {
  VOWEL('a', 'e', 'i', 'o', 'u') {
    public String toString() {
      return "vowel";
    }
  }, SOMETIMES_A_VOWEL('y', 'w') {
    public String toString() {
      return "sometimes a vowel";
    }
  }, CONSONANT {
    public String toString() {
      return "consonant";
    }
  };
  private HashSet<Character> charSet = new HashSet<>();

  private CharType(Character... chars) {
    if (chars != null) {
      charSet.addAll(Arrays.asList(chars));
    }
  }

  public static CharType getCategory(Character c) {
    if (VOWEL.charSet.contains(c)) {
      return VOWEL;
    }
    if (SOMETIMES_A_VOWEL.charSet.contains(c)) {
      return SOMETIMES_A_VOWEL;
    }
    return CONSONANT;
  }
}

public class VowelsAndConsonants {

  public static void main(String[] args) {
    Random rand = new Random(47);
    for (int i = 0; i < 100; i++) {
      int c = rand.nextInt(26) + 'a';
      System.out.print((char) c + ", " + c + ": ");
      System.out.println(CharType.getCategory((char) c).toString());
    }
  }
}
