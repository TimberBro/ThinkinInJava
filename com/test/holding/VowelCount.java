package com.test.holding;

import com.test.util.TextFile;
import java.util.*;

public class VowelCount {
  static Set<Character> vowels =
      new TreeSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

  private static int count(String s) {
    int counter = 0;
    for (Character c : s.toCharArray()) {
      if (vowels.contains(c)) {
        counter++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    int totalCount = 0;
    Set<String> words =
        new TreeSet<String>(new TextFile("com\\test\\holding\\UniqueWords.java", "\\W+"));
    for (String s : words) {
      System.out.println(s + " contains " + count(s) + " vowels.");
      totalCount += count(s);
    }
    System.out.println("Total sum of vowels = " + totalCount);
  }
}
