package com.test.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TextFileToLinkedList {

  public static void main(String[] args) {
    LinkedList<String> list = new LinkedList<>();
    try {
      BufferedReader in = new BufferedReader(new FileReader("com\\test\\util\\Test.txt"));
      while (true) {
        String currentLine = in.readLine();
        if (currentLine != null) {
          list.add(currentLine);
        } else {
          break;
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.println(list.get(i));
    }
  }
}
