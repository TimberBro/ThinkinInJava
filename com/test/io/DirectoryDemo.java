package com.test.io;

import static com.test.util.Print.print;

import com.test.util.Directory;
import java.io.File;

public class DirectoryDemo {

  public static void main(String[] args) {
    // All Java files beginning with '':
    for (File file : Directory.walk(".\\com\\test\\io", "D.*\\.java")) {
      print(file);
    }
  }
}