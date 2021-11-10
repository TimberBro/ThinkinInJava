package com.test.holding;

import com.test.util.TextFile;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class WordCounter {
  final String word;
  private int occurrenceCount;

  WordCounter(String word) {
    this.word = word;
    occurrenceCount = 1;
  }

  public String getWord() {
    return word;
  }

  void increaseCount() {
    occurrenceCount++;
  }

  @Override
  public String toString() {
    return "word='" + word + '\'' + " => " + occurrenceCount;
  }

  // Methods were overridden to use contains method in set
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WordCounter wordCounter = (WordCounter) o;
    return word.equals(wordCounter.word);
  }

  @Override
  public int hashCode() {
    return Objects.hash(word);
  }
}

public class SortWordsInFileMod {

  private static void countWords(Set<WordCounter> counterSet, List<String> list) {
    for (String s : list) {
      WordCounter wordCounter = new WordCounter(s);
      if (!counterSet.contains(wordCounter)) {
        counterSet.add(wordCounter);
      } else {
        for (Iterator<WordCounter> it = counterSet.iterator(); it.hasNext(); ) {
          WordCounter ct = it.next();
          if (ct.getWord().equals(wordCounter.getWord())) {
            ct.increaseCount();
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    List<String> words =
        new LinkedList<>(new TextFile("com\\test\\holding\\UniqueWords.java", "\\W+"));
    System.out.println(words);
    Set<WordCounter> set = new LinkedHashSet<>();
    Collections.sort(words, String.CASE_INSENSITIVE_ORDER);
    countWords(set, words);
    System.out.println(set);
  }
}
