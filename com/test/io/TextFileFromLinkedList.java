package com.test.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class TextFileFromLinkedList {

  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println(
          "Usage java TextFileToLinkedList %full path to input file% %full path to output file%");
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
      } catch (IOException e) {
        e.printStackTrace();
      }

      try {
        PrintWriter out = new PrintWriter(args[1]);
        int lineCount = list.size();
        for (int i = list.size() - 1; i >= 0; i--) {
          out.println(lineCount-- + " : " + list.get(i));
        }
        out.close();
        System.out.println(BufferedInputFile.read(args[1]));
      } catch (FileNotFoundException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
}
