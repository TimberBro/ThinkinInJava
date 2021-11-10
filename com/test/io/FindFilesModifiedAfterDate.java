package com.test.io;

import com.test.util.ProcessFiles;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

public class FindFilesModifiedAfterDate {

  public static void main(String[] args) {
    // Use only DD.MM.YYYY format
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, new Locale("ru"));
    if (args.length != 2) {
      System.err.println("Usage: java FindModifiedAfter path date");
      return;
    }
    long tmp = 0;
    try {
      tmp = df.parse(args[1]).getTime();
    } catch (ParseException e) {
      e.printStackTrace();
    }
    final long modTime = tmp;
    new ProcessFiles(new ProcessFiles.Strategy() {
      public void process(File file) {
        if (modTime < file.lastModified()) {
          System.out.println(file);
        }
      }
    }, ".*\\.java").start(new String[]{args[0]});
  }
}
