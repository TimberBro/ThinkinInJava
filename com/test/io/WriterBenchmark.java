package com.test.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;

public class WriterBenchmark {

  public static void main(String[] args) {
    LinkedList<String> list;
    try {
      list = TextFileToLinkedList.convert("com\\test\\util\\Test.txt");
      PrintWriter out = new PrintWriter(
          new BufferedWriter(new FileWriter("com\\test\\util\\Test.out")));
      int lineCount = 1;
      long t1 = System.currentTimeMillis();
      for (String s : list) {
        for (int i = 0; i < 100000; i++) {
          out.println(lineCount + ": " + s);
        }
        lineCount++;
      }
      long t2 = System.currentTimeMillis();
      out.close();
      System.out.println("Buffered: " + (t2 - t1));

      out = new PrintWriter((new FileWriter("com\\test\\util\\Test.out")));
      lineCount = 1;
      t1 = System.currentTimeMillis();
      for (String s : list) {
        for (int i = 0; i < 100000; i++) {
          out.println(lineCount + ": " + s);
        }
        lineCount++;
      }
      t2 = System.currentTimeMillis();
      out.close();
      System.out.println("Unbuffered: " + (t2 - t1));
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
