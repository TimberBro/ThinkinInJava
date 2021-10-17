package com.test.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class TextFileToLinkedList {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out
          .println("Usage java TextFileToLinkedList %full path to file% \"words to find in file\"");
    } else {
      LinkedList<String> list = new LinkedList<>();
      try {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
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
