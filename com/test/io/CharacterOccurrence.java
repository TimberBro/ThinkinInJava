package com.test.io;

import com.test.util.TextFile;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CharacterOccurrence {
  static Map<Character, Integer> countCharacters(String fileName) {
    Map<Character, Integer> characterMap = new HashMap<>();
    LinkedList<String> list = new LinkedList<>(new TextFile(fileName, "\\W+"));
    for (String word : list) {
      char[] chars = word.toCharArray();
      for (Character c : chars) {
        if (characterMap.get(c) == null) {
          characterMap.put(c, 1);
        } else {
          int ref = characterMap.get(c);
          characterMap.put(c, ++ref);
        }
      }
    }
    return characterMap;
  }

  public static void main(String[] args) {
    System.out.println(countCharacters("com\\test\\io\\CharacterOccurrence.java"));
  }
}
