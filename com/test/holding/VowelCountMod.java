package com.test.holding;

import com.test.util.TextFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class VowelCountMod {
  static Set<Character> vowels =
      new TreeSet<Character>(Arrays.asList('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u'));

  private static int count(Map<Character, Integer> characterMap, String s) {
    int counter = 0;
    for (Character c : s.toCharArray()) {
      if (vowels.contains(c)) {
        counter++;
        saveCharacterStat(characterMap, c);
      }
    }
    return counter;
  }

  private static void saveCharacterStat(Map<Character, Integer> characterMap, Character character) {
    Integer freq = characterMap.get(character);
    characterMap.put(character, freq == null ? 1 : freq + 1);
  }

  public static void main(String[] args) {
    int totalCount = 0;
    Map<Character, Integer> characterOccurrence = new HashMap<Character, Integer>();
    Set<String> words =
        new TreeSet<String>(new TextFile("com\\test\\holding\\UniqueWords.java", "\\W+"));
    for (String s : words) {
      System.out.println(s + " contains " + count(characterOccurrence, s) + " vowels.");
      totalCount += count(characterOccurrence, s);
    }
    System.out.println("Total sum of vowels = " + totalCount);
    System.out.println(characterOccurrence);
  }
}
