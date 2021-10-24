package com.test.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile2 extends ArrayList<String> {

  // Read a file as a single string:
  public static String read(String fileName) throws IOException {
    StringBuilder sb = new StringBuilder();

    BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
    try {
      String s;
      while ((s = in.readLine()) != null) {
        sb.append(s);
        sb.append("\n");
      }
    } finally {
      in.close();
    }
    return sb.toString();
  }

  // Write a single file in one method call:
  public static void write(String fileName, String text) throws FileNotFoundException {

    PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
    try {
      out.print(text);
    } finally {
      out.close();
    }
  }

  // Read a file, split by any regular expression:
  public TextFile2(String fileName, String splitter) throws IOException {
    super(Arrays.asList(read(fileName).split(splitter)));
    // Regular expression split() often leaves an empty
    // String at the first position:
    if (get(0).equals("")) {
      remove(0);
    }
  }

  // Normally read by lines:
  public TextFile2(String fileName) throws IOException {
    this(fileName, "\n");
  }

  public void write(String fileName) throws IOException {
    PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
    try {
      for (String item : this) {
        out.println(item);
      }
    } finally {
      out.close();
    }
  }

  // Simple test:
  public static void main(String[] args) throws IOException {
    String file = read("TextFile.java");
    write("test.txt", file);
    TextFile2 text = new TextFile2("test.txt");
    text.write("test2.txt");
    // Break into unique sorted list of words:
    TreeSet<String> words = new TreeSet<>(new TextFile2("TextFile.java", "\\W+"));
    // Display the capitalized words:
    System.out.println(words.headSet("a"));
  }
}