package com.test.holding;

import com.test.util.TextFile;
import java.util.*;

public class UniqueWords {

  public static void main(String[] args) {
    Set<String> words = new TreeSet<String>(new TextFile("SetOperations.Java", "\\W+"));
    System.out.println(words);
  }
}
