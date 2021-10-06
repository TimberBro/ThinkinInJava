package com.test.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

class DirFilter implements FilenameFilter {

  private Pattern pattern;

  public DirFilter(String regex) {
    pattern = Pattern.compile(regex);
  }

  public boolean accept(File dir, String name) {
    return pattern.matcher(name).matches();
  }
}

public class SortedDirList {

  private File file;

  SortedDirList(File file) {
    this.file = file;
  }

  String[] list() {
    String[] list = file.list();
    Arrays.sort(list);
    return list;
  }

  String[] list(String regex) {
    return file.list(new DirFilter(regex));
  }

  public static void main(String[] args) {
    File file = new File("com//test//io");
    SortedDirList sortedDirList = new SortedDirList(file);
    System.out.println(Arrays.toString(sortedDirList.list()));
    System.out.println(Arrays.toString(sortedDirList.list("D.*\\.java")));
  }
}
