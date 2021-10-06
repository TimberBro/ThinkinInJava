package com.test.containers;

import com.test.util.TextFile;
import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {

  public static void main(String[] args) {
    Set<String> words = new TreeSet<String>(new TextFile("com\\test\\testfiles\\Test.txt", "\\W+"));
    System.out.println(words);
  }
}
