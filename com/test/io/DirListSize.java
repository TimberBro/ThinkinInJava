package com.test.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirListSize {

  public static void main(String[] args) {
    File path = new File("com//test//io");
    String[] list;
    if (args.length == 0) {
      list = path.list();
    } else {
      list = path.list(new FilenameFilter() {
        private Pattern pattern = Pattern.compile(args[0]);

        public boolean accept(File dir, String name) {
          return pattern.matcher(name).matches();
        }
      });
    }
    Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
    long totalSize = 0;
    long currentFileSize;
    for (String dirItem : list) {
      currentFileSize = new File(path, dirItem).length();
      totalSize += currentFileSize;
      System.out.println(dirItem + ": Size in bytes = " + currentFileSize);
    }
    System.out.println("Total bytes = " + totalSize);
  }
}
