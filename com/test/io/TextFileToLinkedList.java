package com.test.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TextFileToLinkedList {

  static LinkedList<String> convert(String path) throws IOException {
    LinkedList<String> list = new LinkedList<>();
    BufferedReader in = new BufferedReader(new FileReader(path));
    while (true) {
      String currentLine = in.readLine();
      if (currentLine != null) {
        list.add(currentLine);
      } else {
        break;
      }
    }
    return list;
  }

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out
          .println("Usage java TextFileToLinkedList %full path to file% \"words to find in file\"");
    } else {
      LinkedList<String> list = new LinkedList<>();
      try {
        list = convert(args[0]);
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }

      int linesCounter = 0;
      for (int i = list.size() - 1; i >= 0; i--) {
        if (list.get(i).contains(args[1])) {
          linesCounter++;
          System.out.println(list.get(i));
        }
      }
      if (linesCounter == 0) {
        System.out.println("Nothing was found.");
      }
    }
  }
}
