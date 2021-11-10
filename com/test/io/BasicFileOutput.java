package com.test.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.io.StringReader;

public class BasicFileOutput {

  static String file = "com\\test\\io\\BasicFileOutput.out";

  public static void main(String[] args) throws IOException {
    LineNumberReader in = new LineNumberReader(
        new StringReader(BufferedInputFile.read("com\\test\\io\\BasicFileOutput.java")));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
    String s;
    while ((s = in.readLine()) != null) {
      out.println(in.getLineNumber() + ": " + s);
    }
    out.close();
    // Show the stored file:
    System.out.println(BufferedInputFile.read(file));
  }
}
